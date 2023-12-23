package com.example.databasewithcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, rollNo, phoneNo, section;
    AutoCompleteTextView courseACTV;
    Spinner spinner;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    Button submit;
    ArrayAdapter spinnerAdapter;
    String[] coursrForSpinner = {"Aasdf","asdfsd","Asdf","EWFe","adfsdfs","sfwef","EFREG","sfwefw","eadwef","EDWREG"};
    String[] courseForACTV = {"CSE","ISE","CST","IST","IIM"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        courseACTV = findViewById(R.id.autoCompleteTextView);
        name = findViewById(R.id.name);
        rollNo = findViewById(R.id.rollNo);
        phoneNo = findViewById(R.id.phoneNo);
        section = findViewById(R.id.section);

        /*
        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);

        /*
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
         */
        submit = findViewById(R.id.submit);


       spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,coursrForSpinner);
        spinner.setAdapter(spinnerAdapter);

        ArrayAdapter ACTVadapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,courseForACTV);
        courseACTV.setThreshold(2);
        courseACTV.setAdapter(ACTVadapter);

        /*

        String actvPass = courseACTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String courseT = parent.getItemAtPosition(i).toString();
            }
        });*/

    }


    public void submit(View view) {
        String spinnerTxt = spinner.getSelectedItem().toString();
        String nameTxt = name.getText().toString();
        String phoneNoTxt = phoneNo.getText().toString();
        String rollNoTxt = rollNo.getText().toString();
        String sectionTxt = section.getText().toString();
//        String actvText =
        Toast.makeText(this, spinnerTxt+nameTxt+rollNoTxt+phoneNoTxt+sectionTxt, Toast.LENGTH_SHORT).show();
    }
}