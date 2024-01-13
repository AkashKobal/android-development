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
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name, phoneNo, date , time;
    AutoCompleteTextView actv;
    Spinner spinner;
    RadioGroup rg;
    RadioButton radioButton1, radioButton2,radioButton3,radioButton4;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4,checkBox5;
    Button next;

    String selectedDataRadioButton ;
    String selectedDataCheckBox = "";

    String[] actvData = {"ACTV1", "ACTV2", "ACTV3", "ACTV4", "ACTV5", "ACTV6"};
    String[] spinnerData = {"Spinner1","Spinner2","Spinner3","Spinner4","Spinner5","Spinner6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        spinner = findViewById(R.id.spinner);
        actv = findViewById(R.id.actv);


//Spinner
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,spinnerData);
        spinner.setAdapter(spinnerAdapter);

        //    ACTV

        ArrayAdapter actvAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,actvData);
        actv.setThreshold(2);
        actv.setAdapter(actvAdapter);
    }



    public void next(View view) {


        //RadioButton
        int selectedRadioButton = rg.getCheckedRadioButtonId();
        if (selectedRadioButton == R.id.radioButton1) {
            selectedDataRadioButton = radioButton1.getText().toString();
        } else if (selectedRadioButton == R.id.radioButton2) {
            selectedDataRadioButton = radioButton2.getText().toString();
        } else if (selectedRadioButton == R.id.radioButton3) {
            selectedDataRadioButton = radioButton3.getText().toString();
        } else if (selectedRadioButton == R.id.radioButton4) {
            selectedDataRadioButton = radioButton4.getText().toString();
        }/* else if (selectedRadioButton == R.id.rb5) {
            selectedDataRadioButton = rb5.getText().toString();
        }*/


// checkBox
        if (checkBox1.isChecked()) {
            selectedDataCheckBox += checkBox1.getText().toString();
        }
        if (checkBox2.isChecked()) {
            selectedDataCheckBox += checkBox2.getText().toString();
        }
        if (checkBox3.isChecked()) {
            selectedDataCheckBox += checkBox3.getText().toString();
        }
        if (checkBox4.isChecked()) {
            selectedDataCheckBox += checkBox4.getText().toString();
        }
        if (checkBox5.isChecked()) {
            selectedDataCheckBox += checkBox5.getText().toString();
        }

        String name1 = name.getText().toString();
        String phoneNo1 = phoneNo.getText().toString();
        String date1 = date.getText().toString();
        String time1 = time.getText().toString();
        String actv1 = actv.getText().toString();
        String spinner1 = spinner.getSelectedItem().toString();
        int radioButton1 = selectedRadioButton;
        String checkBox1 = selectedDataCheckBox;



        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("Name", name1);
        intent.putExtra("PhoneNo", phoneNo1);
        intent.putExtra("Date",date1);
        intent.putExtra("Time",time1);
        intent.putExtra("actv",actv1);
        intent.putExtra("spinner",spinner1);
        intent.putExtra("radiobutton",radioButton1);
        intent.putExtra("checkBox",selectedDataCheckBox);

        startActivity(intent);
        Toast.makeText(this, "Submitted Successfully", Toast.LENGTH_SHORT).show();

    }
    public  void date(View view){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                String dates = dayOfMonth+"/"+(month+1)+"/"+year;
                date.setText(dates);

            }
        },year,month,day);
        datePickerDialog.show();


    }

    public void time(View view) {
        Calendar calendar = Calendar.getInstance();
        int minutes = calendar.get(Calendar.MINUTE);
        int hours = calendar.get(Calendar.HOUR);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int minutes, int hour) {

                String times = minutes +":"+hours;
                time.setText(times);
            }
        },minutes,hours,false);
        timePickerDialog.show();

    }
}