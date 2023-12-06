package com.example.notificationapp;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationResult extends AppCompatActivity {
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        onNewIntent(getIntent());
        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(100);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras!=null) {
            if (extras.containsKey("Message")) {
                setContentView(R.layout.activity_main2);
                String msg = extras.getString("Message");
                res = findViewById(R.id.textDisplay);
                res.setText("Report: "+msg);
            }
            super.onNewIntent(intent);
        }
    }
}