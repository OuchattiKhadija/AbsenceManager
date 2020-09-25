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

public class CustomAdapterSeance extends RecyclerView.Adapter<CustomAdapterSeance.MyViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList id_seance, sMod, date, timeS, timeE, user_id, class_id;

    public CustomAdapterSeance(Activity activity, Context context, ArrayList seance_id, ArrayList sMod, ArrayList date, ArrayList timeS, ArrayList timeE, ArrayList user_id, ArrayList class_id) {
        this.activity = activity;
        this.context = context;
        this.id_seance = seance_id;
        this.sMod = sMod;
        this.date = date;
        this.timeS = timeS;
        this.timeE = timeE;
        this.user_id = user_id;
        this.class_id = class_id;
    }

    @NonNull
    @Override
    public CustomAdapterSeance.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.raw_seance, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.Name.setText(String.valueOf(sMod.get(position)));
        holder.timeS.setText(String.valueOf(timeS.get(position)));
        holder.timeE.setText(String.valueOf(timeE.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Student.class);
                intent.putExtra("idC", String.valueOf(class_id.get(position)));
                intent.putExtra("idU", String.valueOf(user_id.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }


    @Override
    public int getItemCount() {
        return id_seance.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name, timeS, timeE;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.seanceName);
            timeS = itemView.findViewById(R.id.timeS);
            timeE = itemView.findViewById(R.id.timeE);
            mainLayout = itemView.findViewById(R.id.mainLayout2);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}