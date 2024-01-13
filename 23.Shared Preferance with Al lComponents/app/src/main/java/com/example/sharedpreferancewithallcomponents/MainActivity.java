package com.example.sharedpreferancewithallcomponents;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText name,phoneNo,ticket;
    AutoCompleteTextView actv;
    Button submit;
    String[] spinnerData = {"Spinner1","Spinner2","Spinner3","Spinner4","Spinner5 "};
    String[] actvData = {"ACTV1","ACTV2","ACTV3","ACTV4"};

    int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        ticket = findViewById(R.id.ticket);
        submit = findViewById(R.id.submitBtn);
        name = findViewById(R.id.name);
        phoneNo = findViewById(R.id.phoneNo);
        actv = findViewById(R.id.actv);


        ArrayAdapter adapterSpinner = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerData);
        spinner.setAdapter(adapterSpinner);

        ArrayAdapter adapterACTV = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, actvData);
        actv.setThreshold(2);
        actv.setAdapter(adapterACTV);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        String s2 = sh.getString("phoneNo", "");
        int a = sh.getInt("ticket", 0);
        name.setText(s1);
        phoneNo.setText(s2);
        ticket.setText(String.valueOf(a));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("name", name.getText().toString());
        myEdit.putString("phoneNo", phoneNo.getText().toString());
        myEdit.putInt("ticket", Integer.parseInt(ticket.getText().toString()));
        myEdit.apply();
    }

    public void submit(View view) {
        Toast.makeText(this, "Successfully Submitted", Toast.LENGTH_SHORT).show();
    }
}