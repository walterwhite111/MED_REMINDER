package com.example.med_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    TextView welcomeUser;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        welcomeUser = findViewById(R.id.welcomeUser);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        welcomeUser.setText("At your service," + " " + userName + "!");

    }
}