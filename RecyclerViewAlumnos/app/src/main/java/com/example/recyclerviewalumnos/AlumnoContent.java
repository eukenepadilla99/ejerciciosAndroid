package com.example.recyclerviewalumnos;

import java.util.ArrayList;
import java.util.List;

public class AlumnoContent {

    //a static class for data (book) model. Names were changed to english for maintaining
    //coherence in all the application.
    public static class AlumnoItem {
        private int id;
        private String nombre;
        private String apellidos;
        private String curso;
        private String ciclo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getCurso() {
            return curso;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }

        public String getCiclo() {
            return ciclo;
        }

        public void setCiclo(String ciclo) {
            this.ciclo = ciclo;
        }


        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public AlumnoItem(int id, String nombre, String apellidos, String curso, String ciclo) {


                this.id = id;
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.curso = curso;
                this.ciclo = ciclo;




        }


        public static List<AlumnoItem> getITEMS() {
            return ITEMS;
        }

        public static  List<AlumnoItem> ITEMS = new ArrayList<>();
        static{
            AlumnoItem alumno1 = new AlumnoItem(1, "Gustabo", "Pancracino Martinez",
                    "2", "Sistemas informaticos");

            AlumnoItem alumno2 = new AlumnoItem(2, "Frankenstein", "El Muerto No Tan Muerto",
                    "1", "Monstroususo");

            AlumnoItem alumno3 = new AlumnoItem(3, "El quijote", "El Loco A Caballo",
                    "1", "Como ser un jinete");

            AlumnoItem alumno4 = new AlumnoItem(4, "Homero", "La odisea",
                    "2", "Los griegos y sus tragedias");

            AlumnoItem alumno5 = new AlumnoItem(5, "Macbeth", "Shakespeare",
                    "1", "Un montón de escoceses matándose");

            AlumnoItem alumno6 = new AlumnoItem(6, "Metamorfosis", "Franz Kafka",
                    "2", "Como convertirse en animales");

            AlumnoItem alumno7 = new AlumnoItem(7, "Jekyll", "Louis Stevenson",
                    "1", "Está loco pero lo maquillamos");

            AlumnoItem alumno8 = new AlumnoItem(8, "Isla", "Stevenson",
                    "2", "Siempre seremos niños");

            ITEMS.add(alumno1);
            ITEMS.add(alumno2);
            ITEMS.add(alumno3);
            ITEMS.add(alumno4);
            ITEMS.add(alumno5);
            ITEMS.add(alumno6);
            ITEMS.add(alumno7);
            ITEMS.add(alumno8);
        }
    }

}
