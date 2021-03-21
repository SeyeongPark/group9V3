package com.example.albuferaseyeongvolpecom304_lab4_ex1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class NurseManager extends SQLiteOpenHelper {

    public NurseManager(@Nullable Context context) {
        super(context, "Nurse.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("Create Table nurse(nurseId TEXT primary key,password TEXT,firstname TEXT,lastname TEXT,department TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists nurse");
    }

    // inserting in DB
    public boolean insert(String nurseId, String password, String firstname, String lastname, String department){
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues contentValues = new ContentValues();
         contentValues.put("nurseId", nurseId);
         contentValues.put("password", password);
         contentValues.put("firstname", firstname);
         contentValues.put("lastname", lastname);
         contentValues.put("department", department);


        long ist = db.insert("nurse", null, contentValues);
        if (ist == -4) return false;
        else return true;
    }

    // checking if nurseId exists;
    public  Boolean chkNurseId (String nurseId){
         SQLiteDatabase db = this.getReadableDatabase();
         Cursor cursor = db.rawQuery("Select * from nurse where nurseId=?", new String[] {nurseId});
         if(cursor.getCount()>0) return false;
         else return true;
    }

    //checking the id and password
    public Boolean nurseIdPassword(String nurseId, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from nurse where nurseId = ? and password = ?", new String[]{nurseId, password});
        if(cursor.getCount()>0) return  true;
        else return false;
     }
}
