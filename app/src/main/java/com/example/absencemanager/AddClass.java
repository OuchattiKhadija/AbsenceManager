package com.example.absencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class AddClass extends AppCompatActivity {
    EditText intitule,fillier,desc;
    DataBaseHelper db;
    Cursor cursor;
    int idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        setTitle("Ajouter nouvelle classe");
        db = new DataBaseHelper(this);
    }


    public void saveClass(View view) {
        intitule = (EditText) findViewById(R.id.intitule);
        fillier = (EditText) findViewById(R.id.fillier);
        desc = (EditText) findViewById(R.id.description);
        String sIntitule = intitule.getText().toString();
        String sFillier = fillier.getText().toString();
        String sDesc = desc.getText().toString();
    }

    private void toListClasses() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}