package com.example.boxcode;

import static com.example.boxcode.OpenHelper.DB_TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boxcode.MainActivity;
import com.example.boxcode.OpenHelper;

import java.util.ArrayList;

public class add_data extends AppCompatActivity {

    TextView btn,btn2,btn3;

    RecyclerView recyclerView;

    OpenHelper openhelper;
    MyAdapter2 adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        btn=findViewById(R.id.close);
        btn2=findViewById(R.id.donebtn);
        btn3=findViewById(R.id.openbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_main();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(add_data.this, "Changes Saved Successfully!!", Toast.LENGTH_SHORT).show();
                open_main();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bottomsheet bottomsheet = new Bottomsheet();
                bottomsheet.show(getSupportFragmentManager(),"TAG");
            }
        });


        recyclerView = findViewById(R.id.recycleview1);
        openhelper = new OpenHelper(this);

        SQLiteDatabase sqLiteDatabase = openhelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+DB_TABLE_NAME,null);
        ArrayList<Model> modelArrayList = new ArrayList<>();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String task_name = cursor.getString(1);
            String task_des = cursor.getString(2);
            String starttime = cursor.getString(3);
            String endtime = cursor.getString(4);
            modelArrayList.add(new Model(id,task_name,task_des,starttime,endtime));
        }
        cursor.close();
        adapter = new MyAdapter2(this,R.layout.userentry2,modelArrayList,sqLiteDatabase);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void open_main()
    {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
