package com.oscar.career.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oscar.career.database.MYdata.Student;

import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.AppHolder> {
    List<Student> data;

    public RecAdapter(List<Student> data){
        this.data = data;
    }


    @NonNull
    @Override
    public AppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item,parent,false);

        return new AppHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AppHolder holder, int position) {
        holder.rollno.setText(String.valueOf(data.get(position).enrollNo));
        holder.name.setText(data.get(position).name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class AppHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView rollno;

        public AppHolder(@NonNull View itemView) {

            super(itemView);

            name = itemView.findViewById(R.id.name);
            rollno = itemView.findViewById(R.id.rollno);


        }
    }
}
