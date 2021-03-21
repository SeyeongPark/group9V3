package com.example.albuferaseyeongvolpecom304_lab4_ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    NurseManager nurseManager;
    EditText nurseId, password, firstName, lastName, department;
    Button btnLogin, btnRegisterPage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        nurseManager = new NurseManager(this);
        nurseId = (EditText)findViewById(R.id.txtId);
        password = (EditText)findViewById(R.id.txtPassword);
        firstName = (EditText)findViewById(R.id.tvPatientId);
        lastName = (EditText)findViewById(R.id.tvNurseId);
        department = (EditText)findViewById(R.id.tvBPL);

        btnLogin=(Button)findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputId = nurseId.getText().toString();
                String inputPassword = password.getText().toString();
                String inputFirstName = firstName.getText().toString();
                String inputLastName = lastName.getText().toString();
                String inputDepartment = department.getText().toString();

                if (inputId.equals("")||inputPassword.equals("")||inputFirstName.equals("")||inputLastName.equals("")||inputDepartment.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean chkNurseId = nurseManager.chkNurseId(inputId);
                    if(chkNurseId == true) {
                        Boolean insert = nurseManager.insert(inputId, inputPassword, inputFirstName, inputLastName, inputDepartment);

                        if (insert == true){
                            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "The ID Already Exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }

    public void onClickToLoginPage(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
