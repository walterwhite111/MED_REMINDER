package com.example.med_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyMedications extends AppCompatActivity {
    Button addNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_medications);
        addNew = findViewById(R.id.addNew);


        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyMedications.this, AddNewMed.class);
                startActivity(intent);
            }
        });
    }
}