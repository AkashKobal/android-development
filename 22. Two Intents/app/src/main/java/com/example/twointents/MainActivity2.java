package com.example.twointents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText name, phoneNo;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.name);
        phoneNo = findViewById(R.id.phoneNo);
        submit = findViewById(R.id.submit);

    }
    public void submit(View view){
        Intent intent2 = getIntent();
        String name2 = intent2.getStringExtra("Name");
        String phoneNo2 = intent2.getStringExtra("PhoneNo");

        Intent intent3 = new Intent(this, MainActivity3.class);
        String name3 = name.getText().toString();
        String phoneNo3 = phoneNo.getText().toString();
        intent3.putExtra("name2",name2);
        intent3.putExtra("phoneNo2",phoneNo2);
        intent3.putExtra("name3",name3);
        intent3.putExtra("phoneNo3",phoneNo3);
        startActivity(intent3);


    }
}