package com.example.med_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddNewMed extends AppCompatActivity {
    EditText medicationName;
    Button addition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_med);
        medicationName = findViewById(R.id.medicationName);
        addition = findViewById(R.id.addition);


        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String medicineName = medicationName.getText().toString();


                Intent intent = new Intent(AddNewMed.this, MyMedications.class);


                intent.putExtra("MEDICINE_NAME", medicineName);

                startActivity(intent);
            }
        });

    }

}