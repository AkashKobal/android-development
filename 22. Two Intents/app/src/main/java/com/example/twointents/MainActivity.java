package com.example.twointents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, phoneNo;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        phoneNo = findViewById(R.id.phoneNo);
        next = findViewById(R.id.submit);
    }

    public void next(View view) {
        String name1 = name.getText().toString();
        String phoneNo1 = phoneNo.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("Name", name1);
        intent.putExtra("PhoneNo", phoneNo1);
        startActivity(intent);
    }
}