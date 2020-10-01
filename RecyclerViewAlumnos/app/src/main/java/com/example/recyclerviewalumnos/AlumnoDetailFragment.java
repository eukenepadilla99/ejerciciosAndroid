package com.example.recyclerviewalumnos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AlumnoDetailFragment extends Fragment {


    //Variables in inflated layout
    private TextView tvNombreAlumno;
    private TextView tvApellidoAlumno;
    private TextView tvCicloAlumno;
    private TextView tvCursoAlumno;


    private int idAlumno;
    private String NombreAlumno;



    public AlumnoDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param index Parameter 1.
     * @param nombre Parameter 2.
     * @return A new instance of fragment AlumnoDetailFragment.
     */

    public static AlumnoDetailFragment newInstance(int index, String nombre) {
        AlumnoDetailFragment fragment = new AlumnoDetailFragment();

        Bundle args = new Bundle();
        args.putInt(Values.PARAM_INDICE, index);
        args.putString(Values.PARAM_NOMBRE, nombre);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idAlumno = getArguments().getInt(Values.PARAM_INDICE);
            NombreAlumno = AlumnoContent.AlumnoItem.ITEMS.get(idAlumno).getNombre();

        }
    }

}
