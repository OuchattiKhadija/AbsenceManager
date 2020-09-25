package com.example.absencemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Seance extends AppCompatActivity {
    String idUs,idCl;
    RecyclerView recyclerView;
    TextView title ,tStart,tEnd;
    int int_idU,int_idC;
    DataBaseHelper db;
    ArrayList<String> seance_id, sMod, date, timeS,timeE,user_id,class_id;
    CustomAdapterSeance customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seance);
        setTitle("Seances");
        db = new DataBaseHelper(this);
        idUs = getIntent().getStringExtra("idU");
        idCl = getIntent().getStringExtra("idC");
        seance_id = new ArrayList<>();
        sMod = new ArrayList<>();
        date = new ArrayList<>();
        timeS = new ArrayList<>();
        timeE = new ArrayList<>();
        user_id = new ArrayList<>();
        class_id = new ArrayList<>();

        int_idU = Integer.parseInt(idUs);
        int_idC = Integer.parseInt(idCl);
        ViewAllSeance();
        customAdapter = new CustomAdapterSeance(Seance.this,this,seance_id, sMod, date,timeS,timeE,user_id,class_id);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Seance.this));

    }
    public void add_seance(View view) {
        Intent intent = new Intent(this, AddSeance.class);
        intent.putExtra("EXTRA_SESSION_IDU", idUs);
        intent.putExtra("EXTRA_SESSION_IDC", idCl);
        startActivityForResult(intent, 1);

    }
    public void ViewAllSeance(){
        Cursor res = db.getAllSeance(int_idC);
        if (res.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No seance to list it",Toast.LENGTH_SHORT).show();
        }else {
            while (res.moveToNext()){
                seance_id.add(res.getString(0));
                sMod.add(res.getString(1));
                date.add(res.getString(2));
                timeS.add(res.getString(3));
                timeE.add(res.getString(4));
                user_id.add(res.getString(5));
                class_id.add(res.getString(6));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.addStudent){
            addStudent();
        }
        return super.onOptionsItemSelected(item);
    }

    private void addStudent() {
        Toast.makeText(getApplicationContext(),"This Fonctionality will be added later",Toast.LENGTH_SHORT).show();

    }
}