public class Viva {

    }

    /////////////////////////// Todo List

    editText=findViewById(R.id.teditText);listView=findViewById(R.id.listview);button=(Button)findViewById(R.id.button);
    ArrayList<String> listOfItem = new ArrayList<>();
    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
            listOfItem);listView.setAdapter(adapter);

    button.setOnClickListener(new View.OnClickListener(){

    public void onClick(View v) {
            String item = editText.getText().toString();
            listOfItem.add(item);
            adapter.notifyDataSetChanged();
        }
    }

            //Remove item from list

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String item = parent.getItemAtPosition(position).toString();

                    listOfItem.remove(item);

                    adapter.notifyDataSetChanged();
                }
            });


////////////////////////////// Intent

// FirstActivity

    public void button(View view) {
        Intent intent;
        intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("Name", "Akash");
        intent.putExtra("RollNo:", 10);
        startActivity(intent);
    }

    // secondActivity

    Intent fromMainActivity = getIntent();
    String name = fromMainActivity.getStringExtra("Name");
    int rollNo = fromMainActivity.getIntExtra("RollNo:",0);textView=

    findViewById(R.id.textView);
     textView.setText("Name:"+name+"\n"+"Roll No:"+rollNo);
}}

    ////////////////////////////// Registration form

    name=findViewById(R.id.NameBox);fname=findViewById(R.id.FNameBox);places=findViewById(R.id.PlaceBox);btn=findViewById(R.id.SubmitBtn);

    // AutoCompleteTextView
    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item,
            Locations);places.setThreshold(1);places.setAdapter(adapter);

    // RadioButton
    rg=

    findViewById(R.id.GenderGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = findViewById(checkedId);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res1 = "Name: " + name.getText().toString() + "\n" + "Father Name: " +
                        fname.getText().toString() + "\n" + "Gender: " + rb.getText() + "\n" + "Place of Birth: "
                        + places.getText().toString();
                Toast.makeText(MainActivity.this, res1, Toast.LENGTH_SHORT).show();
            }
        });
    }}

    Calendar calendar = Calendar.getInstance();
    int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    int month = Calendar.getInstance().get(Calendar.MONTH);
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int minute = Calendar.getInstance().get(Calendar.MINUTE);
    int hour = Calendar.getInstance().get(Calendar.HOUR);

    // datePicker
    public void date(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dates = dayOfMonth + "/" + year + "/" + (month+1) ;
                date.setText(dates);
            }
        },10,07,2023);datePickerDialog.show();
    }

    // timePicker
    public void time(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String times = hourOfDay+":"+minute;
                time.setText(times);
            }
        },00,00,false);timePickerDialog.show();
    }}

    // checkBox
    CheckBox checkBox1, checkBox2, checkBox3;checkBox1=

    findViewById(R.id.checkBox1);
    checkBox2 = findViewById(R.id.checkBox2);
    checkBox3 = findViewById(R.id.checkBox3);

    public void next(View view) {
        CheckBox checkbox1 = findViewById(R.id.checkBox1);
        CheckBox checkbox2 = findViewById(R.id.checkBox2);
        CheckBox checkbox3 = findViewById(R.id.checkBox3);

        String checkedCheckboxData = "";
        if (checkBox1.isChecked()) {
            checkedCheckboxData += checkbox1.getText().toString() + ", ";
        }
        if (checkBox2.isChecked()) {
            checkedCheckboxData += checkBox2.getText().toString() + ", ";
        }
        if (checkBox3.isChecked()) {
            checkedCheckboxData += checkBox3.getText().toString() + ", ";
        }
        Toast.makeText(this, checkedCheckboxData, Toast.LENGTH_SHORT).show();

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

    ////////////// Media Player
    Button btnPause, btnPlay, btnStop;

    @Override
        btnPause = findViewById(R.id.btnPause);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String aPath = "android.resource://"+getPackageName()+"/raw/song2";

        String onlineAudioPath = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
       Uri audioURI = Uri.parse(aPath);

        try{
            mp.setDataSource(this,audioURI);
            mp.prepare();

        }
        catch (Exception e){

        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();

            }
        });


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause(); 
                mp.seekTo(0); 

            }
        });

        //mp.seekTo(0); // play the audio from from where ever we want to satrt
//        mp.getDuration() to skip the song with specific seconds
//        mp.getCurrentPosition();

//        setOnCompletionListener is used when the song is finished and we want to play next song.
       /* mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {


            }
        });*/

    }}

    /////////////////// Database

    EditText eid, ename;
    Button ins, del, dis;
    TextView res;
    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eid = findViewById(R.id.idBox);
        ename = findViewById(R.id.nameBox);
        ins = findViewById(R.id.insertBtn);
        del = findViewById(R.id.deleteBtn);
        dis = findViewById(R.id.displayBtn);
        res = findViewById(R.id.result);
        db = new MyDbHelper(getApplicationContext(), "students", null, 1);
    }

    public void add(View view) {
        String sid = eid.getText().toString();
        String sname = ename.getText().toString();
        db.insertRecord(sid, sname);
        Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();
    }

    public void delete(View view) {
        String sid = eid.getText().toString();
        db.deleteRecord(sid);
        Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
    }

    public void display(View view) {
        String tabledata = db.displayRecord();
        res.setText(tabledata);
    }
}

//// Class
public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(@Nullable Context context, @Nullable String name, @Nullable
        SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table students (stuId varChar(10),stuname varChar(20))");
        }


        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        }


        public void insertRecord(String sid,String sname){

            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("insert into students values (?,?)",new String[]{sid,sname});

//            db.close();
        }


        public void deleteRecord(String sid){
            SQLiteDatabase db = this.getWritableDatabase();

            db.delete("students","stuId=?",new String[]{sid});
        }


        public String displayRecord(){
            String tdata = "";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from students",null);
            while (cursor.moveToNext()) {
                String i = cursor.getString(0);
                String n = cursor.getString(1);
                tdata += i+":"+n+"\n";
            }


//            db.close();
            return tdata;
        }
    }



    /////////////////// Shared Preference

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