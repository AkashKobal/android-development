package com.example.a48intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent fromMainActivity = getIntent(); // fetching the data from previous screen and stored in a variable fromMainActivity
        // getting the data through key, and storing in a variable
        String name = fromMainActivity.getStringExtra("Name"); // different key got different method to get data , example for int (.getIntExtra), for Srting (.getString)
        int rollNo = fromMainActivity.getIntExtra("RollNo:",0); // set defalut value to numbers(int,float,double) type only, in case key doesnot match it return default value only in number
        //but in string method by default it leave blank space


        textView = findViewById(R.id.textView);
        textView.setText("Name:"+name+"\n"+"Roll No:"+rollNo);
//        getSupportActionBar().setTitle("Second Screen"); // setting the title for the screen

    }
}