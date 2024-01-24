package com.example.med_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    Button logIn;
    TextView moveToReg;
    EditText nameLog;
    EditText passwordLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logIn = findViewById(R.id.logIn);
        moveToReg = findViewById(R.id.moveToReg);
        nameLog = findViewById(R.id.nameLog);
        passwordLog = findViewById(R.id.passwordLog);


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userNameLogIn = nameLog.getText().toString();
                String passwordLogIn = passwordLog.getText().toString();

                if (TextUtils.isEmpty(userNameLogIn) || TextUtils.isEmpty(passwordLogIn)) {
                    Toast.makeText(LogIn.this, "Enter all required data!", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(LogIn.this, MainMenu.class);
                    intent.putExtra("USER_NAME", userNameLogIn);
                    startActivity(intent);
                    finish();
                }
            }
        });

        moveToReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, Register.class);
                startActivity(intent);
                finish();
            }
        });
    }
}