package com.example.registrationdatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RegistrationDatabase rdb;
    EditText id, name, rollNo, section;
    Button submit, delete, display;
    TextView displaydb;
    RadioGroup radioGroup;
    RadioButton maleButton, femaleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        rollNo = findViewById(R.id.rollNo);
        section = findViewById(R.id.section);
        displaydb = findViewById(R.id.displaydb);
        submit = findViewById(R.id.submit);
        delete = findViewById(R.id.delete);
        display = findViewById(R.id.display);
        radioGroup = findViewById(R.id.radioGroup);
        maleButton = findViewById(R.id.maleButton);
        femaleButton = findViewById(R.id.femaleButton);
        rdb = new RegistrationDatabase(getApplicationContext(),"REGISTRATION",null,1);

    }

    public void submit(View view) {
        String id1 = id.getText().toString();
        String name1 = name.getText().toString();
        String rollNo1 = rollNo.getText().toString();
        String section1 = section.getText().toString();
        rdb.insertValues(id1,name1,rollNo1,section1);

        Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_LONG).show();

    }

    public void delete(View view) {
        String idD = id.getText().toString();
        rdb.deleteValues(idD);
        Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
    }

    public void display(View view) {
        String tableData1 = rdb.displayDatabase();
        displaydb.setText(tableData1);
    }
}