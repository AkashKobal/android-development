package com.example.twointents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView resultFromFirstActivity, resultFromSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        resultFromFirstActivity = findViewById(R.id.resultFormFirstActivity);
        resultFromSecondActivity = findViewById(R.id.resultFormSecondActivity);


        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name2");
        String phoneNo1 = intent.getStringExtra("phoneNo2");
        String date1 = intent.getStringExtra("Date2");
        String time1 = intent.getStringExtra("Time2");
        String actv1 = intent.getStringExtra("actv2");
        String spinner1 = intent.getStringExtra("spinner2");
        String radioButton1 = intent.getStringExtra("radioButton2");
        String checkBox1 = intent.getStringExtra("checkBox2");


        String name2 = intent.getStringExtra("name3");
        String phoneNo2 = intent.getStringExtra("phoneNo3");
        String date2 = intent.getStringExtra("date3");
        String time2 = intent.getStringExtra("time3");
        String actv2 = intent.getStringExtra("actv3");
        String spinner2 = intent.getStringExtra("spinner3");
        String radioButton2 = intent.getStringExtra("radioButton3");
        String checkBox2 = intent.getStringExtra("checkBox3");




        resultFromFirstActivity.setText("Name:"+name1+"\n"+"Phone No:"+phoneNo1+"\n"+"Date :"+date1+"\n"+"Time:"+time1+"\n"+"ACTV:"+actv1+"\n"+"Spinner :"+spinner1+"\n"+"RadioButton :"+radioButton1+"\n"+"CkechBox :"+checkBox1);
        resultFromSecondActivity.setText("Name:"+name2+"\n"+"Phone No:"+phoneNo2 +"\n"+"Date :"+date2+"\n"+"Time:"+time2+"\n"+"ACTV:"+actv1+"\n"+"Spinner :"+spinner2+"\n"+"RadioButton :"+radioButton2+"\n"+"CkechBox :"+checkBox2);


    }
}