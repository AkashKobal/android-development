public class notification {
    
}
//////////////// Notification 
EditText bp,temp;
    Button btn;
    Integer bp_int,temp_int;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bp = findViewById(R.id.bpBox);
        temp = findViewById(R.id.tempBox);
        btn = findViewById(R.id.submitBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                bp_int = Integer.parseInt(bp.getText().toString());
                temp_int = Integer.parseInt(temp.getText().toString());
                String msg;
                int notificationId = 100;
                if((bp_int>=60&&bp_int<=100)||temp_int==98)
                    msg = "Your Vitals are fine";
                else
                    msg = "You need to consult doctor";
                String CHANNEL_ID = "my_ch";
                String CHANNEL_NAME = "my_channel";
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel channel = new
                        NotificationChannel(CHANNEL_ID,CHANNEL_NAME,importance);
                NotificationManager manager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel);
                Intent it = new Intent(MainActivity.this, NotificationResult.class);
                it.putExtra("Message",msg);
                it.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent pintent =
                        PendingIntent.getActivity(MainActivity.this,0,it,PendingIntent.FLAG_UPDATE_CURRENT);
                NotificationCompat.Builder builder = new
                        NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setContentIntent(pintent);
                builder.setSmallIcon(R.drawable.download);
                builder.setContentTitle("Vital Conditions");
                builder.setContentText("BP: "+bp_int+" Temperature: "+temp_int);
                manager.notify(notificationId,builder.build());
            }
        });
    }
}

public class NotificationResult extends AppCompatActivity {
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        onNewIntent(getIntent());
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(100);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("Message")) {
                setContentView(R.layout.activity_main2);
                String msg = extras.getString("Message");
                res = findViewById(R.id.textDisplay);
                res.setText("Report: " + msg);
            }
            super.onNewIntent(intent);
        }
    }
}