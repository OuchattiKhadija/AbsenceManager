package com.example.absencemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class Home extends AppCompatActivity {
    DataBaseHelper db;
    String idSession;
    RecyclerView recyclerView;
    ArrayList<String> classId,classIntitule,classFillier;
    CustomAdapterClasses customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DataBaseHelper(this);
        setTitle("Classes");
        idSession = getIntent().getStringExtra("EXTRA_SESSION_ID");
        classFillier = new ArrayList<>();
        classId = new ArrayList<>();
        classIntitule = new ArrayList<>();
        ViewAllClass();
        customAdapter = new CustomAdapterClasses(Home.this,this, classIntitule, classFillier);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Home.this));

        }

    public void ViewAllClass(){
        Cursor res = db.getAllClasses();
        if (res.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No classes to list it",Toast.LENGTH_SHORT).show();
        }else {
            while (res.moveToNext()){
                classId.add(res.getString(0));
                classIntitule.add(res.getString(1));
                classFillier.add(res.getString(2));
            }
        }
        }

    public void add_class(View view) {
        Intent intent = new Intent(this, AddClass.class);
        intent.putExtra("EXTRA_SESSION_ID", idSession);
        startActivity(intent);
    }
}