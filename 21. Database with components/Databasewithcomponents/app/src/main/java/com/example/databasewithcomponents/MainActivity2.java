package com.example.databasewithcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        result =findViewById(R.id.result);
        Intent intent2 = getIntent();
        String name =  intent2.getStringExtra("name");
        String phoneNo = intent2.getStringExtra("phoneNo");
        String rollNo = intent2.getStringExtra("rollNo");
//        String section = intent2.getStringExtra("section");
//        String radio = intent2.getStringExtra("radio");
//        String checkBox = intent2.getStringExtra("checkBox");
        startActivity(intent2);
        result.setText(name+phoneNo+rollNo);
//        result.setText("Name :"+name+"\n"+"Phone :"+phoneNo+"\n"+"Roll No:"+rollNo+"\n"+"Section :"+section+"\n"+"radio :"+radio+"\n"+"checkBox :"+checkBox);

    }
}