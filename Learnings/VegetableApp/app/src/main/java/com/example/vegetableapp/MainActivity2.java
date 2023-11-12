package com.example.vegetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    EditText quantity, date;
    Button checkOut;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        quantity = findViewById(R.id.quantity);
        date = findViewById(R.id.date);
        checkOut = findViewById(R.id.checkOut);
        display = findViewById(R.id.display);
    }

    public void date(View view) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dates = dayOfMonth+"/"+(month+1)+"/"+year;
                date.setText(dates);
            }
        },day,month,year);
        datePickerDialog.show();
    }

    public void checkOut(View view) {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phoneNo =  intent.getStringExtra("phoneNo");
        String selectedItems = intent.getStringExtra("checkBoxData");

        String price = quantity.getText().toString();
        Double prices = Double.parseDouble(price);
        Double priced = prices*25;
        display.setText("Name :"+name+"\n"+"Phone No:"+phoneNo+"\n"+"Items Selected :"+selectedItems+"\n"+"Price : "+ priced);

    }
}