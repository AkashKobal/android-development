package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        Intent fromMainActivity = getIntent();
        String m_name = fromMainActivity.getStringExtra("Name :");
        String m_rool = fromMainActivity.getStringExtra("Roll no. :");
        String m_date = fromMainActivity.getStringExtra("Date :");
        String m_time = fromMainActivity.getStringExtra("Time :");
        String m_spinner = fromMainActivity.getStringExtra("Course :");



        //CheckBox
        String m_MSG = fromMainActivity.getStringExtra("MSG");

        textView.setText("Name :"+m_name+"\n"+"Roll No :"+m_rool+"\n"+"Date :"+m_date+"\n"+"Time :"+m_time+"\n"+"Course :"+m_spinner+"\n"+"Gender"+m_MSG);
    }
}