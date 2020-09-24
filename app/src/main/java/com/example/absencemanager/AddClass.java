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
    String uId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        setTitle("Ajouter nouvelle classe");
        uId = getIntent().getStringExtra("EXTRA_SESSION_ID");
        db = new DataBaseHelper(this);
    }


    public void saveClass(View view) {
        intitule = (EditText) findViewById(R.id.intitule);
        fillier = (EditText) findViewById(R.id.fillier);
        desc = (EditText) findViewById(R.id.description);
        String sIntitule = intitule.getText().toString();
        String sFillier = fillier.getText().toString();
        String sDesc = desc.getText().toString();
        int idUser = db.getUserId(uId);
        if(sIntitule.equals("")|| sFillier.equals("")){
            Toast.makeText(getApplicationContext(),"intitulé and fillier are requered",Toast.LENGTH_SHORT).show();
        }else{
            Boolean addClass = db.addClass(sIntitule,sFillier,sDesc,idUser);
            if (addClass == true){
                toListClasses();
            } else {
                Toast.makeText(getApplicationContext(),"Some thing wrong try agan",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void toListClasses() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}