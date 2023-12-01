package com.example.registrationdatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class RegistrationDatabase extends SQLiteOpenHelper {
    public RegistrationDatabase (@Nullable Context context,@Nullable String name,@Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        SQLiteDatabase sqldb = this.getWritableDatabase();
        sqLiteDatabase.execSQL("CREATE TABLE REGISTRATION_TABLE(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),rollNo VARCHAR(20)," +
                "section VARCHAR(20)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertValues(String id, String name, String rollNo, String section){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO REGISTRATION_TABLE VALUES(?,?,?,?)",new String[]{id,name,rollNo,section});
//        sqLiteDatabase.close();
    }
    public void deleteValues(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("REGISTRATION_TABLE","id = ?",new String[] {id});
    }
    public String displayDatabase(){
        String tableData = "";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM REGISTRATION_TABLE",null);
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String rollNo = cursor.getString(2);
            String section = cursor.getString(3);
            tableData = id+name+rollNo+section;
        }
//        sqLiteDatabase.close();
        return tableData;
    }
}
