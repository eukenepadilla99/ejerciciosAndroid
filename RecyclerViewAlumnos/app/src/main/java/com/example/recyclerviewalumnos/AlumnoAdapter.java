package com.example.recyclerviewalumnos;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoBasicViewHolder> {

    public static class AlumnoBasicViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNombre;
        public TextView tvApellidos;
        public TextView tvCiclo;
        public TextView tvCurso;

        public AlumnoBasicViewHolder(View itemView) {

            super(itemView);


            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellidos = itemView.findViewById(R.id.tvApellidos);
            tvCiclo = itemView.findViewById(R.id.tvCiclo);
            tvCurso = itemView.findViewById(R.id.tvCurso);


            }

        }



    public AlumnoAdapter(){

    }

    @NonNull
    @Override
    public AlumnoBasicViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alumno, parent, false);

        return new AlumnoBasicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoBasicViewHolder holder, int position) {

        holder.tvNombre.setText(AlumnoContent.AlumnoItem.ITEMS.get(position).getNombre());
        Log.d("miFiltro","Nombre "+AlumnoContent.AlumnoItem.ITEMS.get(position).getNombre()+" numero: "+position);
        holder.tvApellidos.setText(AlumnoContent.AlumnoItem.ITEMS.get(position).getApellidos());
        holder.tvCurso.setText(AlumnoContent.AlumnoItem.ITEMS.get(position).getCurso());
        holder.tvCiclo.setText(AlumnoContent.AlumnoItem.ITEMS.get(position).getCiclo());

    }
    @Override

    public int getItemCount() {

        Log.d("miFiltro","Cantidad: "+AlumnoContent.AlumnoItem.ITEMS.size());

        return AlumnoContent.AlumnoItem.ITEMS.size();

    }

}
