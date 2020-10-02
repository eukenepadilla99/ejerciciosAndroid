package com.example.recyclerviewalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        final Toolbar toolbar = findViewById(R.id.toolbarAlumnoList);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle(R.string.app_name);


        recyclerAlumnos = findViewById(R.id.rvAlumnos);

        AlumnoAdapter AlumnoAdapter = new AlumnoAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        recyclerAlumnos.setLayoutManager(mLayoutManager);
        recyclerAlumnos.setItemAnimator(new DefaultItemAnimator());
        recyclerAlumnos.addItemDecoration(new DividerItemDecoration(getBaseContext(), LinearLayoutManager.VERTICAL));
        recyclerAlumnos.setAdapter(AlumnoAdapter);


    }
}