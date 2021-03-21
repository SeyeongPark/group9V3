package com.example.albuferaseyeongvolpecom304_lab4_ex1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestViewActivity extends AppCompatActivity {

    private TestManager testManager;
    private EditText txtTestId;
    private TextView tvPatientId, tvNurseId, tvBPL, tvBPH, tvTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testview);

        testManager = new TestManager(this);
        txtTestId = (EditText)findViewById(R.id.txtTestId);
        tvPatientId = (TextView) findViewById(R.id.tvPatientId);
        tvNurseId = (TextView)findViewById(R.id.tvNurseId);
        tvBPL = (TextView)findViewById(R.id.tvBPL);
        tvBPH = (TextView)findViewById(R.id.tvBPH);
        tvTemperature = (TextView)findViewById(R.id.tvTemperature);
    }

public void showTest(View view)
{
    try {
        Test test = testManager.getTestById(txtTestId.getText().toString(),"testid");
        // Patient patient = patientManager.getPatientById(txtPatientId.getText().toString(), "patientId");
        //txtTest.setText(test.getTestId());
        tvPatientId.setText(String.valueOf(test.getPatientId()));
        tvNurseId.setText(String.valueOf(test.getNurseId()));
        tvBPL.setText(String.valueOf(test.getBPL()));
        tvBPH.setText(String.valueOf(test.getBPH()));
        tvTemperature.setText(String.valueOf(test.getTemperature()));

        Toast.makeText(TestViewActivity.this, "View Patient Record ", Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(getApplicationContext(), TestActivity.class);
        //startActivity(intent);
    }
    catch (Exception exception)
    {
        Toast.makeText(TestViewActivity.this,
                exception.getMessage(), Toast.LENGTH_SHORT).show();
        Log.i("Error: ",exception.getMessage());

    }
}
}
