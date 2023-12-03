package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eid,ename;
    Button ins,del,dis;
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
        db = new MyDbHelper(getApplicationContext(),"students",null,1);
    }

    public void add(View view) {
        String sid = eid.getText().toString();
        String sname = ename.getText().toString();
        db.insertRecord(sid,sname);
        Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
    }

    public void delete(View view) {
        String sid = eid.getText().toString();
        db.deleteRecord(sid);
        Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
    }

    public void display(View view) {
        String tabledata = db.displayRecord();
        res.setText(tabledata);
    }
}
