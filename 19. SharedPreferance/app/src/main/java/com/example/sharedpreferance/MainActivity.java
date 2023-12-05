package com.example.sharedpreferance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner movies;
    EditText ticket;
    Button submit;
    String[] moviesName = {"Animal","Avatar","RRR","KGF"};
    int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies = findViewById(R.id.spinner);
        ticket = findViewById(R.id.ticket);
        submit = findViewById(R.id.submitBtn);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,moviesName);
        movies.setAdapter(adapter);



        movies.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                 selectedPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPreferance",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("MovieName",selectedPosition);
                editor.putInt("TicketsCount",Integer.parseInt(ticket.getText().toString()));
                editor.apply();

                Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MyPreferance",MODE_PRIVATE);
        int spos = sh.getInt("MovieName",0);
        int ct = sh.getInt("TicketsCount",0);
        movies.setSelection(spos);
        ticket.setText(String.valueOf(ct));
    }
}