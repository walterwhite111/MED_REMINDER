package com.example.med_reminder;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddNewMedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNewMedFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    Spinner intakes;
    List<String> optionsIntakes;
    Spinner options;
    List<String> optionsType;
    EditText medicationName;
    Button addition;
    Button calendar;
    Button setStart;
    int hour, minute;

    private String mParam1;
    private String mParam2;

    public AddNewMedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddNewMedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddNewMedFragment newInstance(String param1, String param2) {
        AddNewMedFragment fragment = new AddNewMedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_med,container,false);
        medicationName = view.findViewById(R.id.medicationName);
        addition = view.findViewById(R.id.addition);
        calendar = view.findViewById(R.id.calendar);
        setStart = view.findViewById(R.id.setStart);
        intakes = view.findViewById(R.id.intakes);
        options = view.findViewById(R.id.options);

        optionsIntakes = new ArrayList<String>();
        optionsIntakes.add("1");
        optionsIntakes.add("2");
        optionsIntakes.add("3");
        optionsIntakes.add("4");
        optionsIntakes.add("5");
        optionsIntakes.add("6");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_single_choice, optionsIntakes);
        intakes.setAdapter(dataAdapter);
        intakes.setOnItemSelectedListener(this);

        optionsType = new ArrayList<String>();
        optionsType.add("Pill");
        optionsType.add("Tablets");
        optionsType.add("Syrup");
        optionsType.add("Syringe");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_single_choice, optionsType);
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

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), onTimeSetListener, hour, minute, true);
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


                Intent intent = new Intent(getContext(), MainActivity.class);


                intent.putExtra("MEDICINE_NAME", medicineName);

                startActivity(intent);

            }
        });
        return view;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }


    public void onNothingSelected(AdapterView<?> parent) {

    }
}