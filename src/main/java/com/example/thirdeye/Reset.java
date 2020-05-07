package com.example.thirdeye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Reset extends AppCompatActivity {
EditText edt_reset_password, edt_reset_confirm;
Button btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        edt_reset_password=(EditText)findViewById(R.id.edt_reset_password);
        edt_reset_confirm=(EditText)findViewById(R.id.edt_reset_confirm);
        btn_reset=(Button)findViewById(R.id.btn_reset);


    }
}
