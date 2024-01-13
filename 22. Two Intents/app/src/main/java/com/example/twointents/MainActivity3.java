package com.example.twointents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        result = findViewById(R.id.result);
        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name2");
        String phoneNo2 = intent.getStringExtra("phoneNo2");
        String name2 = intent.getStringExtra("name3");
        String phoneNo3 = intent.getStringExtra("phoneNo3");

        result.setText("Name 1 :"+ name1+"\n"+"Phone No 1 :"+ phoneNo2+"\n"+"Name 2 :"+name2+"\n"+"Phone No 2:"+phoneNo3);

    }
}