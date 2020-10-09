package com.example.trial.ui.galeria;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trial.R;

public class GaleriaActividadesAdapter extends RecyclerView.Adapter<GaleriaActividadesAdapter.GaleriaActividadesBasicViewHolder> {

    public static class GaleriaActividadesBasicViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgGaleriaMostrar;

        public GaleriaActividadesBasicViewHolder(View itemView) {

            super(itemView);


            imgGaleriaMostrar = itemView.findViewById(R.id.imgGaleriaMostrar);



        }

    }



    public GaleriaActividadesAdapter(){

    }

    @NonNull
    @Override
    public GaleriaActividadesBasicViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_galeria_item, parent, false);

        return new GaleriaActividadesBasicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GaleriaActividadesBasicViewHolder holder, int position) {

        Log.d("miFiltro","Nombre "+ GaleriaActividadesContent.GaleriaItem.drawables[position] +" numero: "+position);

        holder.imgGaleriaMostrar.setImageResource(GaleriaActividadesContent.GaleriaItem.drawables[position]);

    }
    @Override

    public int getItemCount() {

        Log.d("miFiltro","Cantidad: "+ GaleriaActividadesContent.GaleriaItem.drawables.length);

        return GaleriaActividadesContent.GaleriaItem.drawables.length;

    }

}
