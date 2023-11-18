package com.example.voteelgiibleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name, num, date;
    Button btn;
    int diff;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nameBox);
        num = findViewById(R.id.aadharBox);
        date = findViewById(R.id.dateBox);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int pYear = c.get(Calendar.YEAR);
                int pMonth = c.get(Calendar.MONTH);
                int pDate = c.get(Calendar.DATE);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_DeviceDefault_DialogWhenLarge, new
                        DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                date.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                                diff = pYear - year;
                            }
                        },pYear, pMonth, pDate);
                dialog.show();
            }
        });
    }

    public void checkEligibility(View v) {
        String s_name = name.getText().toString();
        String s_num = num.getText().toString();
        Intent in = new Intent(getApplicationContext(),MainActivity2.class);
        in.putExtra("NAME",s_name);
        in.putExtra("AADHAR",s_num);
        in.putExtra("AGE",diff);
        startActivity(in);
    }
}