package com.example.absencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Seance extends AppCompatActivity {
    String idUs,idCl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seance);
        setTitle("Seances");
        idUs = getIntent().getStringExtra("idU");
        idCl = getIntent().getStringExtra("idC");
        Toast.makeText(getApplicationContext(),"All firld are requered uId = " + idUs+ "cId = " + idCl,Toast.LENGTH_SHORT).show();

    }
    public void add_seance(View view) {
        Intent intent = new Intent(this, AddSeance.class);
        intent.putExtra("EXTRA_SESSION_IDU", idUs);
        intent.putExtra("EXTRA_SESSION_IDC", idCl);
        startActivityForResult(intent, 1);

    }
}