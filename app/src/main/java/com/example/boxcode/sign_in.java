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

import com.example.boxcode.MainActivity;
import com.example.boxcode.R;
import com.example.boxcode.first_page;

public class sign_in extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;

    TextView btn;
    TextView back;
    TextView back2;
    String a,b,c,d,e;
    TextView forget;
    int n=2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username= findViewById (R.id.username);
        password= findViewById (R.id.password);
        loginButton=findViewById(R.id.loginButton);
        btn=findViewById(R.id.signupText);
        back=findViewById(R.id.backbtn);
        back2=findViewById(R.id.backbtn3);
        forget=findViewById(R.id.forget);

        Intent intent=getIntent();
        a = intent.getStringExtra("username");
        b = intent.getStringExtra("password");
        c = intent.getStringExtra("newpass");
        d = intent.getStringExtra("newus");
        e = intent.getStringExtra("first");


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (username.getText().toString().equals(a) && password.getText().toString().equals(b)) {
                    Toast.makeText(sign_in.this, "Login Successful!!", Toast.LENGTH_SHORT).show();
                    open_sign1();
                } else if (username.getText().toString().equals(d) && password.getText().toString().equals(c)) {
                    Toast.makeText(sign_in.this, "Login Successful!!", Toast.LENGTH_SHORT).show();
                    open_sign1();
                } else if(n==1) {
                    Toast.makeText(sign_in.this, "Login Failed!! (1 attempt remain)", Toast.LENGTH_SHORT).show();
                    n=n-1;
                } else if(n==0) {
                    Toast.makeText(sign_in.this, "Login Failed!!", Toast.LENGTH_SHORT).show();
                    open_sign();
                } else {
                    Toast.makeText(sign_in.this, "Login Failed!! (2 attempt remain)", Toast.LENGTH_SHORT).show();
                    n=n-1;
                }
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { open_forget();}
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_sign();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_sign3();
            }
        });
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_sign3();
            }
        });

    }
    public void open_sign() {
        Intent intent = new Intent(this,sign_up.class);
        startActivity(intent);
    }
    public void open_sign1() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("first",e);
        startActivity(intent);
    }
    public void open_sign3()
    {
        Intent intent = new Intent(this, first_page.class);
        startActivity(intent);
    }

    public void open_forget() {
        Intent intent1 = new Intent(this,forget_pass.class);
        intent1.putExtra("pass",b);
        intent1.putExtra("us",a);
        intent1.putExtra("first",e);
        startActivity(intent1);
    }
}