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

public class sign_up extends AppCompatActivity {

    EditText Firstname;
    EditText second;
    EditText user;
    EditText Pass;
    Button signupButton;
    TextView btn;
    TextView back3;
    TextView back4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Firstname= findViewById (R.id.firstname);
        second= findViewById (R.id.snm);
        user= findViewById(R.id.username);
        Pass = findViewById(R.id.password);
        signupButton = findViewById (R.id.signupBtn);
        btn=findViewById(R.id.siText);
        back3=findViewById(R.id.backbtn4);
        back4=findViewById(R.id.backbtn5);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(Firstname.getText().toString()) || TextUtils.isEmpty(second.getText().toString()) || TextUtils.isEmpty(user.getText().toString()) || TextUtils.isEmpty(Pass.getText().toString()))
                {
                    Toast.makeText(sign_up.this, "Oops! Looks like some fields are empty.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(sign_up.this, "Sign up successful!!", Toast.LENGTH_SHORT).show();
                    open_signin();
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_signin();
            }
        });
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_sign3();
            }
        });
        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_sign3();
            }
        });
    }
    public void open_signin() {
        Intent intent = new Intent(this, sign_in.class);
        intent.putExtra("username",user.getText().toString());
        intent.putExtra("password",Pass.getText().toString());
        intent.putExtra("first",Firstname.getText().toString());
        startActivity(intent);
    }
    public void open_sign3() {
        Intent intent = new Intent(this,sign_in.class);
        startActivity(intent);
    }
}