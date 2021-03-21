package com.example.albuferaseyeongvolpecom304_lab4_ex1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class TestManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TestDB";
    private static final int DATABASE_VERSION = 1;



    private static String TABLE_NAME="Test";
    private static String tableCreatorString=
            "CREATE TABLE "+ TABLE_NAME + " (testId integer primary key, patientId integer, nurseId integer, department text, BPL float, BPH float, temperature float);";
    public TestManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(tableCreatorString);}



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public void dbInitialize(String tableName, String tableCreatorString) {
        this.TABLE_NAME = tableName;
        this.tableCreatorString = tableCreatorString;

    }

    public boolean addRow(ContentValues values) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        long newRow = db.insert(TABLE_NAME, null, values);
        db.close();
        return newRow > -1;
    }

    public  Boolean chkTestId (String testId){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Test where testId=?", new String[] {testId});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public Test getTestById(Object id, String fieldName) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where " + fieldName + "='" + String.valueOf(id) + "'", null);
        Test test = new Test(); //create a new Test object
        if (cursor.moveToFirst()) { //if row exists
            cursor.moveToFirst(); //move to first row
            //initialize the instance variables of task object
            test.setTestId(cursor.getInt(0));
            test.setPatientId(cursor.getInt(1));
            test.setNurseId(cursor.getInt(2));
            test.setBPL(cursor.getFloat(3));
            test.setBPH(cursor.getFloat(4));
            test.setTemperature(cursor.getInt(5));
            cursor.close();

        } else {
            test = null;
        }

        db.close();
        return test;

    }
}



