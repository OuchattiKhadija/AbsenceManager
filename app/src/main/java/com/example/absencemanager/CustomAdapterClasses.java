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
    private ArrayList classIntitule,classFiller;

    CustomAdapterClasses(Activity activity, Context context,ArrayList classIntitule,ArrayList classFiller){
        this.activity = activity;
        this.context = context;
        this.classFiller = classFiller;
        this.classIntitule = classIntitule;
    }
    @NonNull
    @Override
    public CustomAdapterClasses.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterClasses.MyViewHolder holder, int position) {
        holder.class_intitule.setText(String.valueOf(classIntitule.get(position)));
        holder.classFilier.setText(String.valueOf(classFiller.get(position)));
        //Recyclerview onClickListener
        /**holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(book_id.get(position)));
                intent.putExtra("title", String.valueOf(book_title.get(position)));
                intent.putExtra("author", String.valueOf(book_author.get(position)));
                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });**/

    }

    @Override
    public int getItemCount() {
        return classIntitule.size();
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
          //  Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            //mainLayout.setAnimation(translate_anim);
        }

    }
}
