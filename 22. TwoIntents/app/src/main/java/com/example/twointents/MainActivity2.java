package com.example.twointents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    EditText name, phoneNo, date, time;
    AutoCompleteTextView actv;
    Spinner spinner;
    RadioGroup rg;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    Button next;

    String[] actvData = {"ACTV1", "ACTV2", "ACTV3", "ACTV4", "ACTV5", "ACTV6"};
    String[] spinnerData = {"Spinner1", "Spinner2", "Spinner3", "Spinner4", "Spinner5", "Spinner6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.name);
        phoneNo = findViewById(R.id.phoneNo);
        next = findViewById(R.id.submit);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        actv = findViewById(R.id.actv);
        rg = findViewById(R.id.rg);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton2);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        spinner = findViewById(R.id.spinner);
        actv = findViewById(R.id.actv);


//Spinner
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerData);
        spinner.setAdapter(spinnerAdapter);

        //    ACTV

        ArrayAdapter actvAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, actvData);
        actv.setThreshold(2);
        actv.setAdapter(actvAdapter);
    }

    public void date(View view) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity2.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                String dates = dayOfMonth + "/" + (month + 1) + "/" + year;
                date.setText(dates);

            }
        }, year, month, day);
        datePickerDialog.show();


    }

    public void time(View view) {
        Calendar calendar = Calendar.getInstance();
        int minutes = calendar.get(Calendar.MINUTE);
        int hours = calendar.get(Calendar.HOUR);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int minutes, int hour) {

                String times = minutes + ":" + hours;
                time.setText(times);
            }
        }, minutes, hours, false);
        timePickerDialog.show();

    }

    public void submit(View view) {
        Intent intent2 = getIntent();
        String name2 = intent2.getStringExtra("Name");
        String phoneNo2 = intent2.getStringExtra("PhoneNo");
        String date2 = intent2.getStringExtra("Date");
        String time2 = intent2.getStringExtra("Time");
        String actv2 = intent2.getStringExtra("actv");
        String spinner2 = intent2.getStringExtra("spinner");
        String radioButton2 = intent2.getStringExtra("radiobutton");
        String checkBox2 = intent2.getStringExtra("checkBox");

        Intent intent3 = new Intent(this, MainActivity3.class);
        String name3 = name.getText().toString();
        String phoneNo3 = phoneNo.getText().toString();
        String date3 = date.getText().toString();
        String time3 = time.getText().toString();
        String actv3 = actv.getText().toString();
        String spinner3 = spinner.getSelectedItem().toString();

        intent3.putExtra("name2", name2);
        intent3.putExtra("phoneNo2", phoneNo2);
        intent3.putExtra("Date2",date2);
        intent3.putExtra("Time2",time2);
        intent3.putExtra("actv2",actv2);
        intent3.putExtra("spinner2",spinner2);
        intent3.putExtra("radioButton2",radioButton2);
        intent3.putExtra("checkBox2",checkBox2);



        intent3.putExtra("name3", name3);
        intent3.putExtra("phoneNo3", phoneNo3);
        intent3.putExtra("date3", date3);
        intent3.putExtra("time3", time3);
        intent3.putExtra("actv3", actv3);
        intent3.putExtra("spinner3",spinner3);
        startActivity(intent3);


    }
}
