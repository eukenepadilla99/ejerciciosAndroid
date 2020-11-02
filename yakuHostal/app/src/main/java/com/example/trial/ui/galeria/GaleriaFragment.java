package com.example.trial.ui.galeria;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trial.R;

public class GaleriaFragment extends Fragment {

    private GaleriaViewModel galeriaViewModel;
    private ImageView imgHostalIniciarGaleria;
    private ImageView imgActividadesIniciarGaleria;
    private TextView tvTituloImg2Galeria;
    private TextView tvTituloImg1Galeria;
    private TextView tvTituloUbicacionGaleria;
    private ImageView imgMapaCasa;
    private String nombreAbrirGaleria;
    private RecyclerView rvGaleriaImgs;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galeriaViewModel =
                ViewModelProviders.of(this).get(GaleriaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_galeria, container, false);

        final TextView textView = root.findViewById(R.id.tvTituloImg1Galeria);
        imgHostalIniciarGaleria = root.findViewById(R.id.imgHostalIniciarGaleria);
        imgActividadesIniciarGaleria = root.findViewById(R.id.imgActividadesIniciarGaleria);
        tvTituloImg2Galeria = root.findViewById(R.id.tvTituloImg2Galeria);
        tvTituloImg1Galeria = root.findViewById(R.id.tvTituloImg1Galeria);
        tvTituloUbicacionGaleria = root.findViewById(R.id.tvTituloUbicacionGaleria);
        imgMapaCasa = root.findViewById(R.id.imgMapaCasa);
        rvGaleriaImgs = root.findViewById(R.id.rvGaleriaImgs);


        galeriaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);

                imgHostalIniciarGaleria.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        esconderElementos();

                        MiThreadHostalGaleria miThreadHostalGaleria = new MiThreadHostalGaleria();
                        miThreadHostalGaleria.start();

                    }

                });
                imgActividadesIniciarGaleria.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        esconderElementos();

                        MiThreadActividadesGaleria miThreadActividadesGaleria = new MiThreadActividadesGaleria();
                        miThreadActividadesGaleria.start();

                    }
                });


                }
        });
        return root;
        
        
    }
    public class MiThreadHostalGaleria extends Thread {
        public MiThreadHostalGaleria() { }
        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                            GaleriaHostalAdapter galeriaHostalAdapter = new GaleriaHostalAdapter();
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
                            rvGaleriaImgs.setLayoutManager(mLayoutManager);
                            rvGaleriaImgs.setItemAnimator(new DefaultItemAnimator());
                            rvGaleriaImgs.addItemDecoration(new DividerItemDecoration(getActivity().getBaseContext(), LinearLayoutManager.HORIZONTAL));
                            rvGaleriaImgs.setAdapter(galeriaHostalAdapter);
                }
            });
        }
    }

    public class MiThreadActividadesGaleria extends Thread {
        public MiThreadActividadesGaleria() { }
        @Override
        public void run() {
//
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    GaleriaActividadesAdapter galeriaActividadesAdapter = new GaleriaActividadesAdapter();
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
                    rvGaleriaImgs.setLayoutManager(mLayoutManager);
                    rvGaleriaImgs.setItemAnimator(new DefaultItemAnimator());
                    rvGaleriaImgs.addItemDecoration(new DividerItemDecoration(getActivity().getBaseContext(), LinearLayoutManager.HORIZONTAL));
                    rvGaleriaImgs.setAdapter(galeriaActividadesAdapter);

                }
            });
        }
    }


    public void esconderElementos(){

        tvTituloImg1Galeria.setVisibility(View.GONE);
        tvTituloImg2Galeria.setVisibility(View.GONE);
        imgMapaCasa.setVisibility(View.GONE);
        tvTituloUbicacionGaleria.setVisibility(View.GONE);
        imgActividadesIniciarGaleria.setVisibility(View.GONE);
        imgHostalIniciarGaleria.setVisibility(View.GONE);
    }
}