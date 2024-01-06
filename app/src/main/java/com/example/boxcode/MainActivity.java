package com.example.boxcode;

import static com.example.boxcode.OpenHelper.DB_TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView btn,btn2,btn3,dis,dis1;
    String a;

    int tej=0;
    RecyclerView recyclerView;
    MyAdapter adapter;
    OpenHelper openhelper;

    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn3=findViewById(R.id.add_data);
        btn=findViewById(R.id.holiday);
        btn2=findViewById(R.id.task_btn);
        btn3=findViewById(R.id.add_data);
        dis=findViewById(R.id.task);
        dis1=findViewById(R.id.hello_user1);

        Intent intent=getIntent();
        a = intent.getStringExtra("first");

        dis1.setText(a);

        openhelper = new OpenHelper(MainActivity.this);
        recyclerView = findViewById(R.id.recycleview);

        sqLiteDatabase = openhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+DB_TABLE_NAME,null);
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
        adapter = new MyAdapter(MainActivity.this,R.layout.userentry,modelArrayList,sqLiteDatabase);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent1=getIntent();
        a = intent1.getStringExtra("first");

        dis1.setText(a);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_holi();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_holi();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_add();
            }
        });
        dis.setText(tej+"/4 tasks");

    }
    public void open_add()
    {
        Intent intent=new Intent(this,add_data.class);
        startActivity(intent);
    }
    public void open_holi()
    {
        Intent intent = new Intent(this,holiday_ad.class);
        intent.putExtra("first",a);
        startActivity(intent);
    }
}