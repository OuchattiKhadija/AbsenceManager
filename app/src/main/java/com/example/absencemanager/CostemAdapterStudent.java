package com.example.absencemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CostemAdapterStudent extends RecyclerView.Adapter<CostemAdapterStudent.MyViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList id_student, cne, firstName, lastName, class_id;

    public CostemAdapterStudent(Activity activity, Context context, ArrayList id_student, ArrayList cne, ArrayList firstName, ArrayList lastName, ArrayList class_id) {
        this.activity = activity;
        this.context = context;
        this.id_student = id_student;
        this.cne = cne;
        this.firstName = firstName;
        this.lastName = lastName;
        this.class_id = class_id;
    }

    @NonNull
    @Override
    public CostemAdapterStudent.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.raw_student, parent, false);
        return new CostemAdapterStudent.MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.firstName.setText(String.valueOf(firstName.get(position)));
        holder.lastName.setText(String.valueOf(lastName.get(position)));
        //Recyclerview onClickListener
        /**holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Student.class);
                intent.putExtra("idC", String.valueOf(class_id.get(position)));
                intent.putExtra("idU", String.valueOf(id_student.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });**/
    }

    @Override
    public int getItemCount() {
        return id_student.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstName, lastName;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.fistName);
            lastName = itemView.findViewById(R.id.lastName);
            mainLayout = itemView.findViewById(R.id.list_student);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
