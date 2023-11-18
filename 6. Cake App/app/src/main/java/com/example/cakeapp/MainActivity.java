package com.example.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name, phoneNo, date, time;
    Button submit;
    Calendar calendar = Calendar.getInstance();
    int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    int month = Calendar.getInstance().get(Calendar.MONTH);
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int minute = Calendar.getInstance().get(Calendar.MINUTE);
    int hour = Calendar.getInstance().get(Calendar.HOUR);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        phoneNo = findViewById(R.id.phoneNo);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        submit = findViewById(R.id.submit);

    }

    public void submit(View view) {
        String name1 = name.getText().toString();
        String phoneNo1 = phoneNo.getText().toString();
        String date1 = date.getText().toString();
        String time1 = time.getText().toString();
        Intent intent = new Intent(this, MainActivity3_selectItems.class);

//        Intent intent = new Intent(this,MainActivity2_selectOrder.class);
        intent.putExtra("Name :",name1);
        intent.putExtra("Phone :",phoneNo1);
        intent.putExtra("Date :",date1);
        intent.putExtra("Time :",time1);
        startActivity(intent);
    }

    public void date(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dates = dayOfMonth + "/" + year + "/" + (month+1) ;
                date.setText(dates);
            }
        },10,07,2023);datePickerDialog.show();
    }

    public void time(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String times = hourOfDay+":"+minute;
                time.setText(times);
            }
        },00,00,false);timePickerDialog.show();
    }
}