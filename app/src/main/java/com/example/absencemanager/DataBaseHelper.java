package com.example.absencemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(@Nullable Context context) {
        super(context, "DbAbsence.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists user (id integer primary key AUTOINCREMENT NOT NULL ,email text NOT NULL, name text NOT NULL, etab text, passwd text NOT NULL)");
        db.execSQL("Create table if not exists classe(id integer primary key AUTOINCREMENT NOT NULL,intitule text NOT NULL,fillier text NOT NULL, description text, user_id integer , FOREIGN KEY (user_id) REFERENCES user (id) )");
        db.execSQL("Create table if not exists etudiant(id integer primary key AUTOINCREMENT NOT NULL,cne text NOT NULL,firstName text NOT NULL, lastName text, user_id integer,class_id integer , FOREIGN KEY (user_id) REFERENCES user (id),FOREIGN KEY (class_id) REFERENCES classe (id) )");
        db.execSQL("Create table if not exists seance(id integer primary key AUTOINCREMENT NOT NULL,intitulé text NOT NULL,date string NOT NULL, timeStart string , timeEnd string, user_id integer,class_id integer , FOREIGN KEY (user_id) REFERENCES user (id),FOREIGN KEY (class_id) REFERENCES classe (id) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists classe");
        db.execSQL("drop table if exists etudiant");
        db.execSQL("drop table if exists seance");
        onCreate(db);
    }

    // inserting on db
    public boolean insert(String email,String name , String etablissement , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("name",name);
        contentValues.put("etab",etablissement);
        contentValues.put("passwd",password);
        long ins = db.insert("user",null,contentValues);
        if (ins==-1) return false;
        else return true;

    }

    //cheking if email already exist
    public boolean chkmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?",new String[]{email});
        if (cursor.getCount()>0) return false;
        else return true;
    }


    String maill,passwood;
    //checking email and passwd for log in
    public boolean chkMailPswd(String email , String passwd){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=? and passwd =?",new String[]{email,passwd});
        if (cursor.getCount()>0) {
            maill = email;
            passwood = passwd;
            return true;
        }
        else return false;

    }
    public boolean addClass(String intitule,String fillier , String description,int isU){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("intitule",intitule);
        contentValues.put("fillier",fillier);
        contentValues.put("description",description);
        contentValues.put("user_id",isU);
        long ins = db.insert("classe",null,contentValues);
        if (ins==-1) return false;
        else return true;
    }

    public Cursor getAllClasses(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from classe",null);
        return res;
    }

    public int getUserId(String m ){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM user WHERE email = ?";
        String[] parameters = new String[] { m };
        Cursor cursor = db.rawQuery(query, parameters);
        if (cursor.moveToFirst())
            return cursor.getInt(0);
        else
            return -1;
    }

}
