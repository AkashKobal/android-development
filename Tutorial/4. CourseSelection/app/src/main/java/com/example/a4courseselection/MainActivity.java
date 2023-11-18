package com.example.a4courseselection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,rollno;
    Spinner elec;
    TextView res;
    String selectedCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nameBox);
        rollno = findViewById(R.id.rollnoBox);
        elec = findViewById(R.id.electivesBox);
        res = findViewById(R.id.result);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.courses));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        elec.setAdapter(adapter);
        elec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCourse = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void displayDetails(View v) {
        res.setText("Name: "+name.getText().toString()+"\n"+"Roll No: "+rollno.getText().toString()+"\n"+
                "Selected Course: "+selectedCourse);
    }
    public void resetDetails(View v){
        name.setText("");
        rollno.setText("");
        res.setText("");
    }
}
