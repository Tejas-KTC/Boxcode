package com.example.boxcode;

import static com.example.boxcode.OpenHelper2.DB_TABLE_NAME2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class holiday_ad extends AppCompatActivity {
    TextView btn,btn2,btn3,dis,dis1;
    String a;

    int tej=0;
    RecyclerView recyclerView;
    MyAdapter3 adapter;
    OpenHelper2 openhelper;
    SQLiteDatabase sqLiteDatabase;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_ad);
        btn=findViewById(R.id.daily_btn);
        btn2=findViewById(R.id.task_btn);
        btn3=findViewById(R.id.add_data);
        dis=findViewById(R.id.task);
        dis1=findViewById(R.id.hello_user1);

        openhelper = new OpenHelper2(holiday_ad.this);
        recyclerView = findViewById(R.id.recycleview3);

        sqLiteDatabase = openhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+DB_TABLE_NAME2,null);
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
        adapter = new MyAdapter3(holiday_ad.this,R.layout.userentry3,modelArrayList,sqLiteDatabase);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent=getIntent();
        a = intent.getStringExtra("first");

        dis1.setText(a);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_daily();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_daily();
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
    public void open_daily()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void open_add()
    {
        Intent intent=new Intent(this,add_data2.class);
        startActivity(intent);
    }
}