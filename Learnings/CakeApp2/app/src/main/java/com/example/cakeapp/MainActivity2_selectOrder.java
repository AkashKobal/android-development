package com.example.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2_selectOrder extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_select_order);
        result = findViewById(R.id.result);
        /*
        Intent intent4 = getIntent();
        String name2 = intent4.getStringExtra("Name :");
        String phone2 = intent4.getStringExtra("Phone :");
        String date = intent4.getStringExtra("Date :");
        String time = intent4.getStringExtra("Time :");
        result.setText("Name :"+name2+"\n"+"Phone no :"+phone2+"\n"+"Date:"+date+"\n"+"Time:"+time);*/
        // Get the checked box data from the Intent extras:

        Intent intent = getIntent();
        String checkBoxes = intent.getStringExtra("Checked");
        String nameData = intent.getStringExtra("Name :");
        String phoneData = intent.getStringExtra("Phone :");
        String dateData = intent.getStringExtra("Date :");
        String timeData = intent.getStringExtra("Time :");

        result.setText("You Selected :"+checkBoxes+"\n"+"Name :"+nameData+"\n"+"Phone no:"+phoneData+"\n"+"Date :"+dateData+"\n"+"Time :"+timeData);

    }
}