public class sharedPreference {
    
}
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

