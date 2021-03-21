package com.example.albuferaseyeongvolpecom304_lab4_ex1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PatientManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PatientDB";
    private static final int DATABASE_VERSION = 1;

    private static String tableName;
    private static String tableCreatorString;

    public PatientManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreatorString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + tableName);
        onCreate(db);
    }

    public void dbInitialize(String tableName, String tableCreatorString) {
        this.tableName = tableName;
        this.tableCreatorString = tableCreatorString;

    }

    public boolean addRow(ContentValues values) throws Exception {
        SQLiteDatabase db = this.getWritableDatabase();
        long newRow = db.insert(tableName, null, values);
        db.close();
        return newRow > -1;
    }

    public Patient getPatientById(Object id, String fieldName) throws Exception {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + tableName + " where " + fieldName + "='" + String.valueOf(id) + "'", null);
        Patient patient = new Patient(); //create a new Student object
        if (cursor.moveToFirst()) { //if row exists
            cursor.moveToFirst(); //move to first row
            //initialize the instance variables of task object
            patient.setPatientID(cursor.getInt(0));
            patient.setFirstName(cursor.getString(1));
            patient.setLastName(cursor.getString(2));
            patient.setDepartment(cursor.getString(3));
            patient.setNurseID(cursor.getInt(4));
            patient.setRoom(cursor.getString(5));
            cursor.close();

        } else {
            patient = null;
        }

        db.close();
        return patient;

    }
}
