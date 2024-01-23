package com.example.med_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MyMedications extends AppCompatActivity {
    Button addNew;
    ListView medList;
    ArrayList<String> medicationList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_medications);
        addNew = findViewById(R.id.addNew);
        medList = findViewById(R.id.medList);

        Intent intent = getIntent();
        String medicineName = intent.getStringExtra("MEDICINE_NAME");

        if (medicineName != null && !medicineName.isEmpty()) {
            medicationList.add(medicineName);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medicationList);
        medList.setAdapter(adapter);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyMedications.this, AddNewMed.class);
                startActivity(intent);
            }
        });
    }
}