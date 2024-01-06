package com.example.boxcode;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.boxcode.R;

public class first_page extends AppCompatActivity {

    Button btn;
    TextView skips;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        skips=findViewById(R.id.skipbut);
        btn=findViewById(R.id.fsignbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_signin();
            }
        });
        skips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_skip();
            }
        });
    }
    public void open_signin()
    {
        Intent intent=new Intent(this,sign_in.class);
        startActivity(intent);
    }
    public void open_skip()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}