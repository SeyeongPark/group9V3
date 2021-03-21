package com.example.albuferaseyeongvolpecom304_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText inputNurseId, inputPassword;
    Button btnlogin;
    NurseManager nurseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputNurseId = (EditText) findViewById(R.id.inputId);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        btnlogin = (Button) findViewById(R.id.btnSignin);
        nurseManager = new NurseManager(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nurseId = inputNurseId.getText().toString();
                String password = inputPassword.getText().toString();
                if(nurseId.equals("")||password.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean chkNurseInfo = nurseManager.nurseIdPassword(nurseId, password);
                    if(chkNurseInfo==true){
                        Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void onClickToRegisterPage(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}