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

        /*
        Intent intent = getIntent();
        String name =  intent.getStringExtra("name");
        String phoneNo = intent.getStringExtra("phoneNo");
        String rollNo = intent.getStringExtra("rollNo");
        String section = intent.getStringExtra("section");
        String radio = intent.getStringExtra("radio");
        String checkBox = intent.getStringExtra("checkBox");
        result.setText("Name :"+name+"\n"+"Phone :"+phoneNo+"\n"+"Roll No:"+rollNo+"\n"+"Section :"+section+"\n"+"radio :"+radio+"\n"+"checkBox :"+checkBox);
        */
    }
}