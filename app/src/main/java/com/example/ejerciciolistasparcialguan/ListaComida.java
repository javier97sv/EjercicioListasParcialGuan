package com.example.ejerciciolistasparcialguan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import Entidades.InfoOrden;

import static com.example.ejerciciolistasparcialguan.MainActivity.listComida;
import static com.example.ejerciciolistasparcialguan.MainActivity.listOrden;

public class ListaComida extends AppCompatActivity {

    int[] img = {
            R.drawable.img01,
            R.drawable.img02,
            R.drawable.img03,
            R.drawable.img04,
            R.drawable.img05,
            R.drawable.img06,
            R.drawable.img07,
            R.drawable.img08,
            R.drawable.img09
    };

    private ListView lstvComida;
    TextView txTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comida);

        AddComidas();

        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        txTitulo = findViewById(R.id.txTitulo);
        CambiarTitulo();
        lstvComida = findViewById(R.id.lstvComida);
        lstvComida.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listComida.subList(num1(), num2())));

        lstvComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                if(position >= 0 && position < listComida.size()){
                    new AlertDialog.Builder(ListaComida.this).setTitle("¡Aviso!").setMessage("¿Desea seleccionar el plato \"" + listComida.get(position + num1()) + "\"?")
                            .setNegativeButton(android.R.string.cancel, null)
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {// Agregamos y cerramos
                                    AddItemListaOrden(listComida.get(position + num1()), img[position + num1()]);
                                    finish();
                                }
                            }).show();
                }
            }
        });
    }

    private void AddComidas(){
        if(listComida.isEmpty()){
            listComida.add("Carne con verduras");
            listComida.add("Carne asada");
            listComida.add("Carne guisada");

            listComida.add("Ensalada de aguacate, mango y fresas");
            listComida.add("Ensalada de lentejas");
            listComida.add("Ensalada de tomate y queso");

            listComida.add("Lasaña con carne");
            listComida.add("Pasta con Papas y Queso Provolone");
            listComida.add("Pasta Carbonara con Cebollas Dulces");
        }
    }

    private void CambiarTitulo(){
        Bundle b = getIntent().getExtras();
        String v = b.getString("cate");
        txTitulo.setText("Lista de " + v);
    }

    private int num1(){
        Bundle b = getIntent().getExtras();
        int v = b.getInt("id");
        int n = 0;

        if(v == 1){
            n = 0;
        }
        if(v == 2){
            n = 3;
        }
        if(v == 3){
            n = 6;
        }
        return n;
    }

    private int num2(){
        Bundle b = getIntent().getExtras();
        int v = b.getInt("id");
        int n = 0;

        if(v == 1) {
            n = 3;
        }
        if(v == 2){
            n = 6;
        }
        if(v == 3){
            n = 9;
        }
        return n;
    }

    private void AddItemListaOrden(String c, int im){
        InfoOrden io = new InfoOrden();
        Bundle b = getIntent().getExtras();

        String e = b.getString("eda");
        String g = b.getString("gener");
        String u = b.getString("ubicacio");

        io.SetEdad(e);
        io.SetGenero(g);
        io.SetUbicacion(u);
        io.SetComida(c);
        io.SetImg(im);
        listOrden.add(io);
    }
}
