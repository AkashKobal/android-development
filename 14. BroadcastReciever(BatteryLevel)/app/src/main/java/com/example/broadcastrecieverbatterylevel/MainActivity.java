package com.example.broadcastrecieverbatterylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView output;
    MyBroadcastReciever myBroadcastReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myBroadcastReciever = new MyBroadcastReciever(output);
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(myBroadcastReciever, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcastReciever);
    }
}