package com.example.ejerciciolistasparcialguan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Entidades.InfoOrden;

public class MainActivity extends AppCompatActivity {

    public static List<InfoOrden> listOrden;
    public static List<String> listComida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOrden = new ArrayList<>();
        listComida = new ArrayList<String>();
    }

    public void OnClickEncuesta(View v){
        Intent in = new Intent(this, InfoPersonal.class);
        startActivity(in);
    }

    public void OnClicProcesar(View v){
        if(listOrden == null || listOrden.size() == 0){
            new AlertDialog.Builder(this).setTitle("¡Aviso!").setMessage("La lista está vacía").show();
        }else{
            Intent in = new Intent(this, ListaOrden.class);
            startActivity(in);
        }
    }
}
