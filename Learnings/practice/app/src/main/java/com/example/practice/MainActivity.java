package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name, rollNo, date, time;
    Spinner spinner;
    Button submit;
    CheckBox ch, ch1, ch2, ch3;
    String [] course = {"COA","DSA","CNS","MAD","ADS","DCCN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        rollNo = findViewById(R.id.rollno);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, course);
        spinner.setAdapter(adapter);

        ch = findViewById(R.id.checkBox);
        ch1 = findViewById(R.id.checkBox2);
        ch2 = findViewById(R.id.checkBox3);
    }



    public void date(View view) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dated = dayOfMonth+"/"+(month+1)+"/"+year;
                date.setText(dated);
            }
        },day,month,year);
        datePickerDialog.show();
    }

    public void time(View view) {
        Calendar cal = Calendar.getInstance();
        int hr = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timer = hourOfDay+":"+minute;
                time.setText(timer);
            }
        },hr,min,false);
        timePickerDialog.show();

    }

    public void submit(View view) {
        String g_name = name.getText().toString();
        String g_rollno = rollNo.getText().toString();
        String g_time = time.getText().toString();
        String g_date = time.getText().toString();
        String g_spinner = spinner.getSelectedItem().toString();

        //CheckBox
        String msg="";
        if(ch.isChecked())
            msg = msg + " Male ";
        if(ch1.isChecked())
            msg = msg + " Female ";
        if(ch2.isChecked())
            msg = msg + " Other ";


        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("Name :",g_name);
        intent.putExtra("Roll no. :",g_rollno);
        intent.putExtra("Date :",g_date);
        intent.putExtra("Time :",g_time);
        intent.putExtra("Course :",g_spinner);
        intent.putExtra("MSG",msg);




        startActivity(intent);

    }
}