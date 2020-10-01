package com.example.recyclerviewalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerAlumnos;

    private String titulo = "";
    private int indice = 0;

    FrameLayout frameLayoutDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbarAlumnoList);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);

        //we try to take the frame layout, only present in the tablet layout. if not present
        // (== null), we will know we are using a phone

        recyclerAlumnos = findViewById(R.id.rvAlumnos);

        AlumnoAdapter AlumnoAdapter = new AlumnoAdapter();
        recyclerAlumnos.setAdapter(AlumnoAdapter);


    }
}