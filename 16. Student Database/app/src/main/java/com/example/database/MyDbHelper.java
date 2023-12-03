package com.example.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

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

