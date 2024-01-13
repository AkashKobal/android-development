package com.example.databasewithcomponents;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable
    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE COMPONENTDATABASE(Name VARCHAR(255), RollNo VARCHAR(255), PhoneNo VARCHAR(255)," +
                "Section VARCHAR(255), Course VARCHAR(255), Spinner VARCHAR(255), RadioBtn VARCHAR(255), CheckBox VARCHAR(255) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void insertValues(String name, String rollNo, String phoneNo, String section, String course, String spinner, String radioBtn, String checkBox) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO COMPONENTDATABASE (Name, RollNo, PhoneNo, Section, Course, Spinner, RadioBtn, CheckBox) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        db.execSQL(query, new String[]{name, rollNo, phoneNo, section, course, spinner, radioBtn, checkBox});
//        db.close();
    }

    public void deleteValues(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("COMPONENTDATABASE", "Name = ?", new String[]{name});
    }

    public String displayData() {
        String data = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM COMPONENTDATABASE", null);
        while (cursor.moveToNext()) {
            String a = cursor.getString(0);
            String b = cursor.getString(1);
            String c = cursor.getString(2);
            String d = cursor.getString(3);
            String e = cursor.getString(4);
            String f = cursor.getString(5);
            String g = cursor.getString(6);
            String h = cursor.getString(7);
            data += a + b + c + d + e + f + g + h;
        }
        return data;
    }
}

