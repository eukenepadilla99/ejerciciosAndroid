package com.example.recyclerviewalumnos;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlumnoAdapter extends RecyclerView.Adapter {
    private ArrayList<AlumnoContent> alumnos;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final View view;
        public ViewHolder(View view){
            super(view);
            this.view=view;
            name=view.findViewById(R.id.nombre);

        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(alumnos!=null){
    return alumnos.size();
        }else{
            return 0;

        }
    }
}
