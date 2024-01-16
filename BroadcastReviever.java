public class BroadcastReviever {
    
}
 /////////////// Broadcast Reciever (Airplane Mode)

        TextView output;
        MyBroadcastReciever myBroadcastReciever;

        output = findViewById(R.id.output);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myBroadcastReciever = new MyBroadcastReciever(output);
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(myBroadcastReciever, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcastReciever);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReciever);
    }
}

public class MyBroadcastReciever extends BroadcastReceiver {
    TextView output;

    // create a constructor with same clss name
    public void MyBroadcastReciever() {

    }

    public MyBroadcastReciever(TextView output) {

        this.output = output;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            boolean isAirplaneModeOn = Settings.System.getInt(context.getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

            if (isAirplaneModeOn) {
                output.setText("Airplane Mode is ON");
                Toast.makeText(context, "Airplane Mode is ON", Toast.LENGTH_SHORT).show();
            } else {
                output.setText("Airplane Mode is OFF");
                Toast.makeText(context, "Airplane Mode is OFF", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /////////////////////////////////////////// Broadcast Reciever (Battery Level)

    TextView output;
    MyBroadcastReciever myBroadcastReciever;

    output=

    findViewById(R.id.output);

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

    /// Class
    public class MyBroadcastReciever extends BroadcastReceiver {
        TextView output;

        public MyBroadcastReciever() {

        }

        public MyBroadcastReciever(TextView output) {
            this.output = output;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED))
                ;

            int batteryLevel = intent.getIntExtra("level", 0);
            if (batteryLevel <= 15) {
                output.setText("Battery low : " + batteryLevel + "%");
                Toast.makeText(context, "Battery low ", Toast.LENGTH_SHORT).show();
            } else if (batteryLevel >= 15 && batteryLevel <= 99) {
                output.setText("Battery is : " + batteryLevel + "%");
                Toast.makeText(context, "Battery is :", Toast.LENGTH_SHORT).show();

            } else if (batteryLevel == 100) {
                output.setText("Battery is full : " + batteryLevel + "%");
                Toast.makeText(context, "Battery full", Toast.LENGTH_SHORT).show();

            }

            else {
                output.setText("Battery off");
                Toast.makeText(context, "Battery off", Toast.LENGTH_SHORT).show();
            }

        }
    }
