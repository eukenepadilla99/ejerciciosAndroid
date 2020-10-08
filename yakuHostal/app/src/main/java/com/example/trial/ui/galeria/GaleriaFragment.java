package com.example.trial.ui.galeria;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Dimension;
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

import java.io.File;

public class GaleriaFragment extends Fragment {

    private GaleriaViewModel galeriaViewModel;
    private ImageView imgHostalIniciarGaleria;
    private ImageView imgActividadesIniciarGaleria;
    private TextView tvTituloImg2Galeria;
    private TextView tvTituloImg1Galeria;
    private TextView tvTituloUbicacionGaleria;
    private ImageView imgMapaCasa;
    private String nombreAbrirGaleria;


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



        galeriaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);

                imgHostalIniciarGaleria.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        nombreAbrirGaleria=getString(R.string.Hostal);

                        MiThreadGaleria miThreadGaleria = new MiThreadGaleria(nombreAbrirGaleria);
                        miThreadGaleria.start();

                    }

                });
                imgActividadesIniciarGaleria.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        nombreAbrirGaleria=getString(R.string.Actividades);

                        MiThreadGaleria miThreadGaleria = new MiThreadGaleria(nombreAbrirGaleria);
                        miThreadGaleria.start();

                    }
                });


                }
        });
        return root;
        
        
    }
    public class MiThreadGaleria extends Thread {
        private String nombreGaleria;
        private String result;

        public MiThreadGaleria(String nombreGaleria) {
            this.nombreGaleria = nombreGaleria;
        }

        @Override
        public void run() {
//            result = asc(num);

            //necesario para poder usar los elementos visuales (view) y modificarlos
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(nombreGaleria!="null"){
                        //si ha clickado alguna de las dos imagenes, desaparecerá todo lo que no sea esa imagen
                        //aqui van los comunes que desaparecen

                        tvTituloImg1Galeria.setVisibility(View.GONE);
                        tvTituloImg2Galeria.setVisibility(View.GONE);
                        imgMapaCasa.setVisibility(View.GONE);
                        tvTituloUbicacionGaleria.setVisibility(View.GONE);

                        if(nombreGaleria==getString(R.string.Hostal)){

                            imgActividadesIniciarGaleria.setVisibility(View.GONE);


                        }else if(nombreGaleria==getString(R.string.Actividades)){

                            imgHostalIniciarGaleria.setVisibility(View.GONE);

                            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                            float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
                            float dpWidth = displayMetrics.widthPixels / displayMetrics.density;


                            Toast.makeText(getActivity().getApplicationContext(),"Width//Height: "+dpWidth+"//"+dpHeight,Toast.LENGTH_SHORT).show();
                            File dir = new File(Environment.get());
                            File[] files = dir.listFiles();
                            int numberOfFiles = files.length;

//                            GaleriaAdapter alumnoAdapter = new AlumnoAdapter();
//                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
//                            recyclerAlumnos.setLayoutManager(mLayoutManager);
//                            recyclerAlumnos.setItemAnimator(new DefaultItemAnimator());
//                            recyclerAlumnos.addItemDecoration(new DividerItemDecoration(getBaseContext(), LinearLayoutManager.VERTICAL));
//                            recyclerAlumnos.setAdapter(alumnoAdapter);

                        }
                    }else{
                        Toast.makeText(getActivity().getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();

                    }


                }
            });
        }


    }
}