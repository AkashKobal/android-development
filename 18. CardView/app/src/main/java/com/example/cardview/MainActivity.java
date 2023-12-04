package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CardView cardView1, cardView2, cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);

        //design using java(floating type is alowed)
//        cardView1.setCardBackgroundColor(1);
        cardView2.setCardElevation(10.5f);
        cardView3.setMaxCardElevation(15.5f);
        cardView1.setRadius(50.5f);
    }
}