package com.example.arithematiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText aval, bval;
    Button add, sub, mul, div;
    TextView res;
    Double a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aval = findViewById(R.id.aBox);
        bval = findViewById(R.id.bBox);
        add = findViewById(R.id.addBtn);
        sub = findViewById(R.id.subBtn);
        mul = findViewById(R.id.mulBtn);
        div = findViewById(R.id.divBtn);
        res = findViewById(R.id.result);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Double.parseDouble(aval.getText().toString());
                b = Double.parseDouble(bval.getText().toString());
                res.setText("Result: "+(a+b));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Double.parseDouble(aval.getText().toString());
                b = Double.parseDouble(bval.getText().toString());
                res.setText("Result: "+(a-b));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Double.parseDouble(aval.getText().toString());
                b = Double.parseDouble(bval.getText().toString());
                res.setText("Result: "+(a*b));
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Double.parseDouble(aval.getText().toString());
                b = Double.parseDouble(bval.getText().toString());
                if(b!=0)
                    res.setText("Result: "+(a/b));
                else
                    res.setText("Division not possible");
            }
        });
    }
}