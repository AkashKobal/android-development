package com.example.a3registrationform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, fname;
    AutoCompleteTextView places;
    RadioGroup rg;
    RadioButton rb;
    Button btn;
    String[] Locations = {"Bangalore", "Delhi", "Pune", "Bombay", "Chennai", "Hyderabad", "Calcutta"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.NameBox);
        fname = findViewById(R.id.FNameBox);
        places = findViewById(R.id.PlaceBox);
        btn = findViewById(R.id.SubmitBtn);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, Locations);
        places.setThreshold(1);
        places.setAdapter(adapter);

        
        rg = findViewById(R.id.GenderGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = findViewById(checkedId);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res1 = "Name: " + name.getText().toString() + "\n" + "Father Name: " +
                        fname.getText().toString() + "\n" + "Gender: " + rb.getText() + "\n" + "Place of Birth: "
                        + places.getText().toString();
                Toast.makeText(MainActivity.this, res1, Toast.LENGTH_SHORT).show();
            }
        });
    }
}