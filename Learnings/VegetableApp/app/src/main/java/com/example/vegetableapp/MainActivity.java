package com.example.vegetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, phoneNo;
    CheckBox cb1, cb2, cb3, cb4;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        phoneNo = findViewById(R.id.phoneno);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
    }

    public void submit(View view) {
        String name1 = name.getText().toString();
        String phoneNo1 = phoneNo.getText().toString();

        String checkBoxData = "";
        if (cb1.isChecked()){
            checkBoxData = checkBoxData + cb1.getText().toString()+",";
        }if (cb2.isChecked()) {
            checkBoxData = checkBoxData + cb2.getText().toString()+",";

        }if (cb3.isChecked()) {
            checkBoxData = checkBoxData + cb3.getText().toString()+",";

        }if (cb4.isChecked()) {
            checkBoxData = checkBoxData + cb4.getText().toString()+",";
        }

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("name", name1);
        intent.putExtra("phoneNo", phoneNo1);
        intent.putExtra("checkBoxData",checkBoxData);
        startActivity(intent);
    }
}