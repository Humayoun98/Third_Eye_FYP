package com.example.thirdeye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button loginButton,btn_register;
    TextView forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageLogo=(ImageView) findViewById(R.id.imgeLogo);
         edtUsername=(EditText) findViewById(R.id.edtUsername);
         edtPassword=(EditText) findViewById(R.id.edtPassword);
         forget=(TextView)findViewById(R.id.forget);
        loginButton=(Button) findViewById(R.id.logginButton);
        btn_register = (Button) findViewById(R.id.btn_register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email= edtUsername.getText().toString().trim();
                String password=edtPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    edtUsername.setError("Please Enter Email");
                    edtUsername.requestFocus();
                    return;
                }
                if ((TextUtils.isEmpty((password)))){
                    edtPassword.setError("Please Enter Password");
                    edtPassword.requestFocus();
                    return;

                }
            }
        });

       btn_register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, Registration.class);
               startActivity(intent);
           }

       });

       forget.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent in=new Intent(MainActivity.this,Forget.class);
               startActivity(in);
           }
       });

    }

}
