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

public class CustomAdapterClasses extends RecyclerView.Adapter<CustomAdapterClasses.MyViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList classIntitule,classFiller,class_id,user_id;

    CustomAdapterClasses(Activity activity, Context context,ArrayList class_id,ArrayList classIntitule,ArrayList classFiller,ArrayList user_id){
        this.activity = activity;
        this.context = context;
        this.class_id = class_id;
        this.classFiller = classFiller;
        this.classIntitule = classIntitule;
        this.user_id = user_id;
    }
    @NonNull
    @Override
    public CustomAdapterClasses.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterClasses.MyViewHolder holder,final int position) {
        holder.class_intitule.setText(String.valueOf(classIntitule.get(position)));
        holder.classFilier.setText(String.valueOf(classFiller.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Seance.class);
                intent.putExtra("idC", String.valueOf(class_id.get(position)));
                intent.putExtra("idU", String.valueOf(user_id.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return user_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView class_intitule, classFilier;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            class_intitule = itemView.findViewById(R.id.nameClass);
            classFilier = itemView.findViewById(R.id.filierClass);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
          Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
          mainLayout.setAnimation(translate_anim);
        }

    }
}
