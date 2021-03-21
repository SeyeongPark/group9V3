package com.example.albuferaseyeongvolpecom304_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private TestManager testManager;
    private EditText txtTestId, txtTestPatientId, txtTestNurseId, txtBPL, txtBPH, txtTemperature;
    private Button testBtnAdd, testBtnShow;
    private final static String TABLE_NAME = "Test";
    private static final String tableCreatorString =
            "CREATE TABLE "+ TABLE_NAME + " (testId integer primary key, patientId integer, nurseId integer, BPL float, BPH float, temperature float);";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        txtTestId = (EditText) findViewById(R.id.txtTestId);
        txtTestPatientId = (EditText) findViewById(R.id.txtTestPatientId);
        txtTestNurseId = (EditText) findViewById(R.id.txtTestNurseId);
        txtBPL = (EditText) findViewById(R.id.txtBPL);
        txtBPH = (EditText) findViewById(R.id.txtBPH);
        txtTemperature = (EditText) findViewById(R.id.txtTemperature);

        testBtnAdd = (Button)findViewById(R.id.btnAdd);
        testBtnShow=  (Button)findViewById(R.id.btnShow);
        try {
            testManager = new TestManager(this);
            //create the table
            testManager.dbInitialize(TABLE_NAME, tableCreatorString);
        }
        catch(Exception exception)
        {
            Toast.makeText(TestActivity.this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());
        }
    }

    public void addTest(View view) {
        int testId = Integer.parseInt(txtTestId.getText().toString());
        int testPatientId = Integer.parseInt(txtTestPatientId.getText().toString());
        int testNurseId = Integer.parseInt(txtTestNurseId.getText().toString());
        float BPL = Float.parseFloat(txtBPL.getText().toString());
        float BPH = Float.parseFloat(txtBPH.getText().toString());
        float temperature = Float.parseFloat(txtTemperature.getText().toString());

        ContentValues contentValues = new ContentValues();
        contentValues.put("testid", testId);
        contentValues.put("patientid", testPatientId);
        contentValues.put("nurseid", testNurseId);
        contentValues.put("bpl", BPL);
        contentValues.put("bph", BPH);
        contentValues.put("temperature", temperature);
        //
        String strTestId = String.valueOf(testId);
        Boolean chkTestId = testManager.chkTestId(strTestId);
        if(chkTestId==true) {
            try {
                testManager.addRow(contentValues);
                Toast.makeText(TestActivity.this, "Test result recorded", Toast.LENGTH_SHORT).show();
            } catch (Exception exception) {
                //
                Toast.makeText(TestActivity.this,
                        exception.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("Error: ", exception.getMessage());
            }
            //clear the fields
            txtTestId.setText(" ");
            txtTestPatientId.setText(" ");
            txtTestNurseId.setText(" ");
            txtBPL.setText(" ");
            txtBPH.setText(" ");
            txtTemperature.setText(" ");
        }
        else {
            Toast.makeText(this, "This test Id is already exist", Toast.LENGTH_SHORT).show();
        }


    }



}

