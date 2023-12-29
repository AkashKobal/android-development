package com.example.databasewithcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView resultDisplay;
    EditText name, rollNo, phoneNo, section;
    AutoCompleteTextView courseACTV;
    Spinner spinner;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    RadioButton radioButton;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    Button submit, intent;
    ArrayAdapter spinnerAdapter;
    String selectedDataRadioButton ;
    String selectedDataCheckBox = "";
    String[] coursrForSpinner = {"Aasdf","asdfsd","Asdf","EWFe","adfsdfs","sfwef","EFREG","sfwefw","eadwef","EDWREG"};
    String[] courseForACTV = {"CSE","ISE","CST","IST","IIM"};
    MyDatabase db;

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
        radioGroup = findViewById(R.id.radioGroup);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);

        submit = findViewById(R.id.submit);
        intent = findViewById(R.id.delete);
        resultDisplay = findViewById(R.id.resultDisplay);


        db = new MyDatabase(getApplicationContext(),"COMPONENTDATABASE", null,1);

// Spinner
       spinnerAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,coursrForSpinner);
        spinner.setAdapter(spinnerAdapter);
// AutoCompleteTextView
        ArrayAdapter ACTVadapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,courseForACTV);
        courseACTV.setThreshold(2);
        courseACTV.setAdapter(ACTVadapter);


    }


    public void submit(View view) {

        //RadioButton
        int selectedRadioButton = radioGroup.getCheckedRadioButtonId();
        if (selectedRadioButton == R.id.rb1) {
            selectedDataRadioButton = rb1.getText().toString();
        } else if (selectedRadioButton == R.id.rb2) {
            selectedDataRadioButton = rb2.getText().toString();
        } else if (selectedRadioButton == R.id.rb3) {
            selectedDataRadioButton = rb3.getText().toString();
        } else if (selectedRadioButton == R.id.rb4) {
            selectedDataRadioButton = rb4.getText().toString();
        } else if (selectedRadioButton == R.id.rb5) {
            selectedDataRadioButton = rb5.getText().toString();
        }


// checkBox
        if (checkBox1.isChecked()) {
            selectedDataCheckBox += checkBox1.getText().toString();
        }
        if (checkBox2.isChecked()) {
            selectedDataCheckBox += checkBox2.getText().toString();
        }
        if (checkBox3.isChecked()) {
            selectedDataCheckBox += checkBox3.getText().toString();
        }
        if (checkBox4.isChecked()) {
            selectedDataCheckBox += checkBox4.getText().toString();
        }
        if (checkBox5.isChecked()) {
            selectedDataCheckBox += checkBox5.getText().toString();
        }
        if (checkBox6.isChecked()) {
            selectedDataCheckBox += checkBox6.getText().toString();
        }

        String spinnerTxt = spinner.getSelectedItem().toString();
        String nameTxt = name.getText().toString();
        String phoneNoTxt = phoneNo.getText().toString();
        String rollNoTxt = rollNo.getText().toString();
        String sectionTxt = section.getText().toString();
        String courseTxt = courseACTV.getText().toString();
        String radioTxt = selectedDataRadioButton;
        String checkBoxData = selectedDataCheckBox;

        db.insertValues(nameTxt, rollNoTxt, phoneNoTxt, sectionTxt, courseTxt, spinnerTxt, radioTxt, checkBoxData);
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();


//        Toast.makeText(this, spinnerTxt+nameTxt+rollNoTxt+phoneNoTxt+sectionTxt+radioTxt+checkBoxData, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Name :"+nameTxt+"\n"+"Phone :"+phoneNoTxt+"\n"+"Roll No:"+rollNoTxt+"\n"+"Section :"+sectionTxt+"\n"+"radio :"+radioTxt+"\n"+"checkBox :"+checkBoxData,Toast.LENGTH_LONG).show();


    }

    public void delete(View view){

            String nameTxt = name.getText().toString();

            db.deleteValues(nameTxt);
            Toast.makeText(this, "Data deleted", Toast.LENGTH_SHORT).show();


    }

    public void display(View view) {
        String tabledata = db.displayData();
        resultDisplay.setText(tabledata);
    }
}