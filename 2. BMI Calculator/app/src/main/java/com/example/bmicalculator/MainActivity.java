package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText wtval, htval;
    Button btn;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wtval = findViewById(R.id.wtBox);
        htval = findViewById(R.id.htBox);
        btn = findViewById(R.id.calcBtn);
        res = findViewById(R.id.result);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float wt = Float.parseFloat(wtval.getText().toString());
                Float ht_m = Float.parseFloat(htval.getText().toString())/100;
                Float bmi = wt/ (ht_m*ht_m);
                if(bmi < 18.5)
                    res.setText("The BMI is: "+bmi+" \n Under Weight ");
                else if (bmi >= 18.5 && bmi < 24.9)
                    res.setText("The BMI is: "+bmi+" \n Healthy ");
                else if (bmi >= 24.9 && bmi < 30)
                    res.setText("The BMI is: "+bmi+" \n Over Weight ");
                else if (bmi>=30)
                    res.setText("The BMI is: "+bmi+" \n Suffering from obesity ");
            }
        });
    }
}