package com.example.boxcode;

import static com.example.boxcode.OpenHelper2.DB_TABLE_NAME2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.MyViewHolder> {

    public Context context;
    public ArrayList<Model> modelArrayList = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;



    public MyAdapter4(Context context, int userentry2, ArrayList<Model> modelArrayList, SQLiteDatabase sqLiteDatabase){
        this.context=context;
        this.modelArrayList=modelArrayList;
        this.sqLiteDatabase=sqLiteDatabase;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry4,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        final Model model = modelArrayList.get(position);
        holder.task_name.setText(model.getTask_name());
        holder.starttime.setText(model.getTask_starttime());
        holder.endtime.setText(model.getTask_endtime());

        holder.btn.setOnClickListener(new View.OnClickListener() {
            final OpenHelper2 openHelper = new OpenHelper2(context);
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                sqLiteDatabase = openHelper.getReadableDatabase();
                long delete = sqLiteDatabase.delete(DB_TABLE_NAME2,"id ="+model.getId(),null);
                if(delete!=-1){
                    Toast.makeText(context, "Data deleted", Toast.LENGTH_SHORT).show();
                    modelArrayList.remove(position);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView task_name,starttime,endtime;

        ImageView btn;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            task_name=(TextView) itemView.findViewById(R.id.txt_task);
            starttime=(TextView) itemView.findViewById(R.id.starttime1);
            endtime=(TextView) itemView.findViewById(R.id.endtime1);
            btn=(ImageView) itemView.findViewById(R.id.delbtn);
        }
    }
}

