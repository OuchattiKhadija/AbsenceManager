package com.example.absencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class Home extends AppCompatActivity {
    DataBaseHelper db;
    String idSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DataBaseHelper(this);
        setTitle("Classes");
        idSession = getIntent().getStringExtra("EXTRA_SESSION_ID");
        ViewAllClass();
        }

    public void ViewAllClass(){
        Cursor res = db.getAllClasses();
        if (res.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No classes to list it",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"list of classes note empty",Toast.LENGTH_SHORT).show();
            ArrayList<String> ids = new ArrayList();
            ArrayList<String> ClassName = new ArrayList();
            while (res.moveToNext()){
                ids.add(res.getString(0));
                ClassName.add(res.getString(1));
            }
        }
        }

    public void add_class(View view) {
        Intent intent = new Intent(this, AddClass.class);
        intent.putExtra("EXTRA_SESSION_ID", idSession);
        startActivity(intent);
    }
}