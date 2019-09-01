package com.example.ejerciciolistasparcialguan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static List<String> listComidaSeleccionada;
    public static List<String> listComida;
    public static List<String> listEdad;
    public static List<String> listGenero;
    public static List<String> listUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listComidaSeleccionada = new ArrayList<String>();
        listComida = new ArrayList<String>();
        listEdad = new ArrayList<String>();
        listGenero = new ArrayList<String>();
        listUbicacion = new ArrayList<String>();
    }

    public void OnClickEncuesta(View v){
        Intent in = new Intent(this, InfoPersonal.class);
        startActivity(in);
    }
}
