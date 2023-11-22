package com.example.broadcastrecieverbatterylevel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

public class MyBroadcastReciever extends BroadcastReceiver {
    TextView output;
    public MyBroadcastReciever(){

    }
    public MyBroadcastReciever(TextView output) {
        this.output = output;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED));

        int batteryLevel = intent.getIntExtra("level",0);
        if (batteryLevel <= 15) {
            output.setText("Battery low : "+batteryLevel+"%");
            Toast.makeText(context, "Battery low ", Toast.LENGTH_SHORT).show();
        } else if (batteryLevel >= 15 && batteryLevel <= 99) {
            output.setText("Battery is : "+batteryLevel+"%");
            Toast.makeText(context, "Battery is :", Toast.LENGTH_SHORT).show();

        } else if (batteryLevel == 100) {
            output.setText("Battery is full : "+batteryLevel+"%");
            Toast.makeText(context, "Battery full", Toast.LENGTH_SHORT).show();

        }
        /*else {
            output.setText("Battery off");
            Toast.makeText(context, "Battery off",Toast.LENGTH_SHORT).show();
        }*/

    }
}


