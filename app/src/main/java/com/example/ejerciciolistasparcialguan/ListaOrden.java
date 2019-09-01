package com.example.ejerciciolistasparcialguan;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import static com.example.ejerciciolistasparcialguan.MainActivity.listOrden;
import Adaptadores.AdaptadorComida;
import Entidades.InfoOrden;

public class ListaOrden extends AppCompatActivity {

    ListView listvOrden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_orden);

        listvOrden = findViewById(R.id.listvOrden);


        //Establecemos el adaptador
        /*
        setListAdapter(new AdaptadorComida(this,
                R.layout.list_item,
                listOrden));*/

        this.listvOrden.setAdapter(new AdaptadorComida(this,
        R.layout.list_item,
        listOrden));
    }
}
