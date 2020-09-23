package com.example.absencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    EditText mail,passwd;
    Button logIn;
    DataBaseHelper db ;
    String sessionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DataBaseHelper(this);
        setContentView(R.layout.activity_log_in);
        mail = (EditText)findViewById(R.id.prof_mail);
        passwd = (EditText)findViewById(R.id.prof_passwd);
        logIn = (Button) findViewById(R.id.LogIn);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String smail = mail.getText().toString();
                String spasswd = passwd.getText().toString();
                Boolean chkmailPass = db.chkMailPswd(smail,spasswd);
                if (chkmailPass == true){
                    sessionId = smail;
                    Toast.makeText(getApplicationContext(),"Sing In Successfully",Toast.LENGTH_SHORT).show();
                    SendData();
                    login();
                } else {
                    Toast.makeText(getApplicationContext(),"Wrong Email or Password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void login() {
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("EXTRA_SESSION_ID", sessionId);
        startActivity(intent);
    }

    public void SendData(){
       // Intent intent = new Intent(this, AddClass.class);
        // intent.putExtra("EXTRA_SESSION_ID", sessionId);
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

}