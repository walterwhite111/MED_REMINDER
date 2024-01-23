package com.example.med_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button buttonReg;
    EditText nameReg;
    EditText emailAddress;
    EditText passwordReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonReg = findViewById(R.id.buttonReg);
        nameReg = findViewById(R.id.nameReg);
        emailAddress = findViewById(R.id.emailAddress);
        passwordReg = findViewById(R.id.passwordReg);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userNameReg = nameReg.getText().toString();
                String emailAddressReg = emailAddress.getText().toString();
                String passwordRgr = passwordReg.getText().toString();

                if (TextUtils.isEmpty(userNameReg) || TextUtils.isEmpty(emailAddressReg) || TextUtils.isEmpty(passwordRgr)) {
                    Toast.makeText(Register.this, "Enter all required data!", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Register.this, MainMenu.class);
                    intent.putExtra("USER_NAME", userNameReg);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}