package com.example.boxcode;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boxcode.R;
import com.example.boxcode.sign_in;

public class forget_pass extends AppCompatActivity {
    String old_pass,old_user,name;
    EditText e1,e2,e3;
    Button sub;

    TextView btn1,btn2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        sub = findViewById(R.id.submit);
        e1 = findViewById(R.id.old_pass);
        e2 = findViewById(R.id.new_pass);
        e3 = findViewById(R.id.con_pass);
        btn1=findViewById(R.id.backbtn4);
        btn2=findViewById(R.id.backbtn5);

        Intent intent = getIntent();
        old_pass = intent.getStringExtra("pass");
        old_user = intent.getStringExtra("us");
        name = intent.getStringExtra("first");

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(e1.getText().toString()) || TextUtils.isEmpty(e2.getText().toString()) || TextUtils.isEmpty(e3.getText().toString()))
                {
                    Toast.makeText(forget_pass.this, "Oops! Looks like some fields are empty.", Toast.LENGTH_SHORT).show();
                }
                else if(!e1.getText().toString().equals(old_user))
                {
                    Toast.makeText(forget_pass.this, "Please enter username same as compared to old Username!!", Toast.LENGTH_SHORT).show();
                }
                else if (e2.getText().toString().equals(old_pass))
                {
                    Toast.makeText(forget_pass.this, "Please enter password different as compared to old password!!", Toast.LENGTH_SHORT).show();
                }
                else if(!e2.getText().toString().equals(e3.getText().toString()))
                {
                    Toast.makeText(forget_pass.this, "Please enter same new password and re-enter password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(forget_pass.this, "Password reset successfully!!", Toast.LENGTH_SHORT).show();
                    open_signin();
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_signin();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_signin();
            }
        });
    }

    public void open_signin() {
        Intent intent = new Intent(this, sign_in.class);
        intent.putExtra("newpass",e3.getText().toString());
        intent.putExtra("newus",old_user);
        intent.putExtra("first",name);
        startActivity(intent);
    };
}