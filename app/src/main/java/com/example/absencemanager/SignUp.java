package com.example.absencemanager;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    DataBaseHelper db;
    EditText name,mail,etab,pass,cpass;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db = new DataBaseHelper(this);
        name = (EditText) findViewById(R.id.prof_name);
        mail = (EditText) findViewById(R.id.pr_Email);
        etab = (EditText) findViewById(R.id.et);
        pass = (EditText) findViewById(R.id.pr_pass);
        cpass = (EditText) findViewById(R.id.conf_pass);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                String sName = name.getText().toString();
                String sMail = mail.getText().toString();
                String sEta = etab.getText().toString();
                String sPassword = pass.getText().toString();
                String sCoPassword = cpass.getText().toString();
                if(sName.equals("")|| sMail.equals("")|| sEta.equals("")|| sPassword.equals("")|| sCoPassword.equals("")){
                    Toast.makeText(getApplicationContext(),"Some Fields are Empty",Toast.LENGTH_SHORT).show();
                } else {
                    if (sPassword.equals(sCoPassword)) {
                        Boolean chkmail = db.chkmail(sMail);
                        if (chkmail == true){
                            Boolean insert = db.insert(sMail,sName,sEta,sPassword);
                            if (insert == true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                                toLogIn();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(),"Email Already Exist",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Password don't match",Toast.LENGTH_SHORT).show();

                    }
                }
            }

        });
    }
    public void toLogIn() {
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }
}