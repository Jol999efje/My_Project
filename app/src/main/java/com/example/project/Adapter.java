package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    Context context;
    ArrayList <Data> DataArrayList;
    public Adapter(Context context,ArrayList<Data> DataArrayList){
        this.context=context;
        this.DataArrayList=DataArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        Data data=DataArrayList.get(position);
        holder.image.setImageResource(data.image);
        holder.name.setText(data.intro);

    }

    @Override
    public int getItemCount() {
        return DataArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
      //  TextView attribute;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.Cafe_Name);
         //   attribute=itemView.findViewById(R.id.attribute);

        }
    }

}

