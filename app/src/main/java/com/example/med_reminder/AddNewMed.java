package com.example.med_reminder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AddNewMed extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner intakes;
    List<String> optionsIntakes;

    Spinner options;
    List<String> optionsType;
    EditText medicationName;
    Button addition;
    Button calendar;
    Button setStart;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_med);
        medicationName = findViewById(R.id.medicationName);
        addition = findViewById(R.id.addition);
        calendar = findViewById(R.id.calendar);
        setStart = findViewById(R.id.setStart);
        intakes = findViewById(R.id.intakes);
        options = findViewById(R.id.options);

        optionsIntakes = new ArrayList<String>();
        optionsIntakes.add("1");
        optionsIntakes.add("2");
        optionsIntakes.add("3");
        optionsIntakes.add("4");
        optionsIntakes.add("5");
        optionsIntakes.add("6");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, optionsIntakes);
        intakes.setAdapter(dataAdapter);
        intakes.setOnItemSelectedListener(this);

        optionsType = new ArrayList<String>();
        optionsType.add("Pill");
        optionsType.add("Tablets");
        optionsType.add("Syrup");
        optionsType.add("Syringe");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, optionsType);
        options.setAdapter(dataAdapter2);
        options.setOnItemSelectedListener(this);



        setStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        setStart.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(AddNewMed.this, onTimeSetListener, hour, minute, true);
                timePickerDialog.setTitle("Select time");
                timePickerDialog.show();

            }
        });


        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://com.android.calendar/time"));
                startActivity(intent);
            }
        });


        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String medicineName = medicationName.getText().toString();


                Intent intent = new Intent(AddNewMed.this, MyMedications.class);


                intent.putExtra("MEDICINE_NAME", medicineName);

                startActivity(intent);
                finish();
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}