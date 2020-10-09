package com.example.trial.ui.galeria;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trial.R;

public class GaleriaHostalAdapter extends RecyclerView.Adapter<GaleriaHostalAdapter.GaleriaHostalBasicViewHolder> {

    public static class GaleriaHostalBasicViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgGaleriaMostrar;
   
        public GaleriaHostalBasicViewHolder(View itemView) {

            super(itemView);


            imgGaleriaMostrar = itemView.findViewById(com.example.trial.R.id.imgGaleriaMostrar);
         


        }

    }



    public GaleriaHostalAdapter(){

    }

    @NonNull
    @Override
    public GaleriaHostalBasicViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_galeria_item, parent, false);

        return new GaleriaHostalBasicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GaleriaHostalBasicViewHolder holder, int position) {


        Log.d("miFiltro","Nombre "+ GaleriaHostalContent.GaleriaItem.drawables[position] +" numero: "+position);

        holder.imgGaleriaMostrar.setImageResource(GaleriaHostalContent.GaleriaItem.drawables[position]);

    }
    @Override

    public int getItemCount() {

        Log.d("miFiltro","Cantidad: "+ GaleriaHostalContent.GaleriaItem.drawables.length);

        return GaleriaHostalContent.GaleriaItem.drawables.length;

    }

}
