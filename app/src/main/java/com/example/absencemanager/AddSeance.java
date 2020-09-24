package com.example.absencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSeance extends AppCompatActivity {
    String uId,cId ;
    EditText mod,date,timeS,timeE;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_seance);
        setTitle("Ajouter nouvelle Seance");
        db = new DataBaseHelper(this);
        uId = getIntent().getStringExtra("EXTRA_SESSION_IDU");
        cId = getIntent().getStringExtra("EXTRA_SESSION_IDC");
        Button button= (Button) findViewById(R.id.saveSeance);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mod = (EditText) findViewById(R.id.seMod);
                date = (EditText) findViewById(R.id.dateSean);
                timeS = (EditText) findViewById(R.id.timeS);
                timeE = (EditText) findViewById(R.id.timeE);
                String sMod = mod.getText().toString();
                String sDate = date.getText().toString();
                String sTimeS = timeS.getText().toString();
                String sTimeE = timeE.getText().toString();
                int u_id =Integer.parseInt(uId);
                int c_id =Integer.parseInt(cId);
                if(sDate.equals("")|| sMod.equals("") || sTimeS.equals("") || sTimeE.equals("")){
                    Toast.makeText(getApplicationContext(),"All firld are requered ",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean addClass = db.addSeance(sMod,sDate,sTimeS,sTimeE,u_id,c_id);
                    if (addClass == true){
                        Toast.makeText(getApplicationContext(),"Congrats",Toast.LENGTH_SHORT).show();
                        toListSeance();
                    } else {
                        Toast.makeText(getApplicationContext(),"Some thing wrong try agan IDu= "+ u_id + "idC = "+ c_id ,Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }

    private void toListSeance() {
        Intent intent = new Intent(this, Seance.class);
        startActivity(intent);
    }
}