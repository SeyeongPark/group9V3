package com.example.albuferaseyeongvolpecom304_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PatientActivity extends AppCompatActivity {

    private PatientManager patientManager;
    private EditText txtPatientId, txtFirstName, txtLastName, txtDepartment, txtNurseId, txtRoom;
    private Button btnAdd, btnShow;
    private final static String TABLE_NAME = "Patient";
    private static final String tableCreatorString =
            "CREATE TABLE "+ TABLE_NAME + " (patientId integer primary key, firstName text, lastName text, department text, nurseId integer, roomId integer);";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        txtPatientId = (EditText) findViewById(R.id.txtpatientId);
        txtFirstName = (EditText) findViewById(R.id.tvPatientId);
        txtLastName = (EditText) findViewById(R.id.tvNurseId);
        txtDepartment = (EditText) findViewById(R.id.tvBPL);
        txtNurseId = (EditText) findViewById(R.id.tvBPH);
        txtRoom = (EditText) findViewById(R.id.tvTemperature);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnShow = (Button)findViewById(R.id.btnShow);

        try {
            patientManager = new PatientManager(this);
            //create the table
            patientManager.dbInitialize(TABLE_NAME, tableCreatorString);
        }
        catch(Exception exception)
        {
            Toast.makeText(PatientActivity.this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());
        }

    }

    public void addPatient(View view)
    {

        int patientId = Integer.parseInt(txtPatientId.getText().toString());
        String firstName = txtFirstName.getText().toString();
        String lastName = txtLastName.getText().toString();
        String department = txtDepartment.getText().toString();
        int nurseId = Integer.parseInt(txtNurseId.getText().toString());
        String room = txtRoom.getText().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put("patientId",patientId);
        contentValues.put("firstName",firstName);
        contentValues.put("lastName",lastName);
        contentValues.put("department",department);
        contentValues.put("nurseId",nurseId);
        contentValues.put("roomId",room);
        //
        try {
            patientManager.addRow(contentValues);
        }
        catch(Exception exception)
        {
            //
            Toast.makeText(PatientActivity.this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());

        }


    }

    public void showPatient(View view)
    {
        try {
            Patient patient = patientManager.getPatientById(txtPatientId.getText().toString(), "patientId");
            txtFirstName.setText(patient.getFirstName());
            txtLastName.setText(patient.getLastName());
            txtDepartment.setText(patient.getDepartment());
            txtNurseId.setText(String.valueOf(patient.getNurseID()));
            txtRoom.setText(patient.getRoom());
        }
        catch (Exception exception)
        {
            Toast.makeText(PatientActivity.this,
                    exception.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("Error: ",exception.getMessage());
        }
    }
}