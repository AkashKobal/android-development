package com.example.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

//create a class and extend it with BroadcastReceiver
// because multiple inheritance is not supported in java thats why we need to create new class
public class MyBroadcastReciever extends BroadcastReceiver {
    TextView output;

    //create a constructor with same clss name
    public void MyBroadcastReciever() {

    }

    public MyBroadcastReciever(TextView output) {

        this.output = output;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
//        boolean airPlaneModeOn = intent.getBooleanExtra("state", false);
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            boolean isAirplaneModeOn = Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

            if (isAirplaneModeOn) {
                output.setText("Airplane Mode is ON");
                Toast.makeText(context, "Airplane Mode is ON", Toast.LENGTH_SHORT).show();
            } else {
                output.setText("Airplane Mode is OFF");
                Toast.makeText(context, "Airplane Mode is OFF",Toast.LENGTH_SHORT).show();
            }

        }
    }
}


























/*
import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
            if (isAirplaneModeOn) {
                // Airplane mode is on
            } else {
                // Airplane mode is off
            }
        }
    }
}
*/


