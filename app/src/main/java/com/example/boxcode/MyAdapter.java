package com.example.boxcode;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public Context context;
    public ArrayList<Model> modelArrayList = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;



    public MyAdapter(Context context, int userentry, ArrayList<Model> modelArrayList, SQLiteDatabase sqLiteDatabase){
        this.context=context;
        this.modelArrayList=modelArrayList;
        this.sqLiteDatabase=sqLiteDatabase;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        final Model model = modelArrayList.get(position);
        holder.task_name.setText(model.getTask_name());
        holder.task_des.setText(model.getTask_des());
        holder.start_time.setText(model.getTask_starttime());
        holder.end_time.setText(model.getTask_endtime());


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView task_name;
        TextView task_des;
        TextView start_time,end_time;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            task_name=(TextView) itemView.findViewById(R.id.txt_task1);
            task_des=(TextView) itemView.findViewById(R.id.txt_des1);
            start_time=(TextView) itemView.findViewById(R.id.starttime);
            end_time=(TextView) itemView.findViewById(R.id.endtime);
        }
    }
}

