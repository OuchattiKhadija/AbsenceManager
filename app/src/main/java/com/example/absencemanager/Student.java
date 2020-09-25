package com.example.absencemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Student extends AppCompatActivity {
    String idUs,idCl;
    int id_class;
    DataBaseHelper db;
    RecyclerView recyclerView;
    CostemAdapterStudent costemAdapterStudent;
    ArrayList<String> student_id, cne, firstName, lastName,classId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        setTitle("Presence Etudiant");
        db = new DataBaseHelper(this);
        idUs = getIntent().getStringExtra("idU");
        idCl = getIntent().getStringExtra("idC");
        id_class = Integer.parseInt(idCl);
        final ArrayList <StudentClass> students = new ArrayList<StudentClass>();
        students.add(new StudentClass(1,"1512002142","Khadija","Ouchatti",id_class));
        students.add(new StudentClass(2,"1512072142","Esaaddiq","Lakhlifi",id_class));
        students.add(new StudentClass(3,"1512402142","Abdellah","Sabbari",id_class));
        students.add(new StudentClass(4,"1517002142","Ilham","Ben Bahia",id_class));
        students.add(new StudentClass(5,"1512672142","Fatima Ezahrae","Elbouni",id_class));
        students.add(new StudentClass(6,"1512082142","Rachid","Oubaha",id_class));
        students.add(new StudentClass(7,"1512092142","Hanae","El omari",id_class));
        students.add(new StudentClass(8,"1512002142","Mouad","Tahiri",id_class));
        students.add(new StudentClass(9,"1512002142","Bouthaina","AL Abdelaazizi",id_class));
        students.add(new StudentClass(10,"1512202142","Respo","Oubtou",id_class));
        students.add(new StudentClass(11,"1513002142","Mohamed","Loughmari",id_class));
        students.add(new StudentClass(12,"1542002142","LAtifa","Ouchatti",id_class));
        students.add(new StudentClass(13,"1552002142","Abdelfattah","Ouchatti",id_class));
        students.add(new StudentClass(14,"1562002142","Abdelhak","Ouchatti",id_class));
        for(StudentClass stu : students){
            Boolean addStudent = db.addStudent(stu.getId(),stu.getCne(),stu.getFirstName(),stu.getLastName(),stu.getIdClass());
            if (addStudent == true){
                Toast.makeText(getApplicationContext(),"Student List is ready",Toast.LENGTH_LONG).show();
            }
        }
        student_id = new ArrayList<>();
        cne = new ArrayList<>();
        firstName = new ArrayList<>();
        lastName = new ArrayList<>();
        classId = new ArrayList<>();
        ViewAllStudent();
        costemAdapterStudent = new CostemAdapterStudent(Student.this,this,student_id, cne, firstName,lastName,classId);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        recyclerView.setAdapter(costemAdapterStudent);
        recyclerView.setLayoutManager(new LinearLayoutManager(Student.this));
    }

    private void ViewAllStudent() {
        Cursor res = db.getAllStudent(id_class);
        if (res.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No Student to list it",Toast.LENGTH_SHORT).show();
        }else {
            while (res.moveToNext()){
                student_id.add(res.getString(0));
                cne.add(res.getString(1));
                firstName.add(res.getString(2));
                lastName.add(res.getString(3));
                classId.add(res.getString(4));
            }
        }

    }


    public void Absence(View view) {
        Toast.makeText(getApplicationContext(),"This Fonctionality will be added later",Toast.LENGTH_SHORT).show();
    }
}