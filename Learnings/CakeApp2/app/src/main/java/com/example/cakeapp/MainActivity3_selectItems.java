package com.example.cakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity3_selectItems extends AppCompatActivity {
    CheckBox checkBox1, checkBox2, checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_select_items);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);


    }

    public void next(View view) {
        // Get the references to the 3 checkboxes:
        CheckBox checkbox1 = findViewById(R.id.checkBox1);
        CheckBox checkbox2 = findViewById(R.id.checkBox2);
        CheckBox checkbox3 = findViewById(R.id.checkBox3);

// Create a string to store the checked checkbox data:
        String checkedCheckboxData = "";
// Check if checkbox1 is checked, and add its data to the string:
        if (checkBox1.isChecked()) {
            checkedCheckboxData += checkbox1.getText().toString() + ", ";
        }
// Check if checkbox2 is checked, and add its data to the string:
        if (checkBox2.isChecked()) {
            checkedCheckboxData += checkBox2.getText().toString() + ", ";
        }
// Check if checkbox3 is checked, and add its data to the string:
        if (checkBox3.isChecked()) {
            checkedCheckboxData += checkBox3.getText().toString() + ", ";
        }
// Display the checked checkbox data:
        Toast.makeText(this,checkedCheckboxData,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2_selectOrder.class);

        // Get the data from the mmain activity and pass to third screen
        Intent dataFromMainActivity = getIntent();
        String nameDate = dataFromMainActivity.getStringExtra("Name :");
        intent.putExtra("Name :",nameDate);
        String phoneNumberData = dataFromMainActivity.getStringExtra("Phone :");
        intent.putExtra("Phone :",phoneNumberData);
        String dateDate = dataFromMainActivity.getStringExtra("Date :");
        intent.putExtra("Date :",dateDate);
        String timeDate = dataFromMainActivity.getStringExtra("Time :");
        intent.putExtra("Time :",timeDate);

        intent.putExtra("Checked",checkedCheckboxData);
        startActivity(intent);
    }
}