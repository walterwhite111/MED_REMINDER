package com.example.med_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    TextView welcomeUser;
    Button myMedications;
    Button addMedication;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        welcomeUser = findViewById(R.id.welcomeUser);
        myMedications = findViewById(R.id.myMedications);
        addMedication = findViewById(R.id.addMedication);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        welcomeUser.setText("At your service," + " " + userName + "!");

        myMedications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MyMedications.class);
                startActivity(intent);
            }
        });
        addMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, AddNewMed.class);
                startActivity(intent);
            }
        });


    }
}