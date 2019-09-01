package com.example.ejerciciolistasparcialguan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Categoria extends AppCompatActivity {
    RadioButton rCarne, rEnsalada, rPasta;
    int n1 = 1;
    int n2 = 2;
    int n3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        rCarne = findViewById(R.id.rCarne);
        rEnsalada = findViewById(R.id.rEnsalada);
        rPasta = findViewById(R.id.rPasta);
    }

    public void OnClickListaComida(View v){
        Intent in = new Intent(this, ListaComida.class);
        Bundle b = getIntent().getExtras();

        if(rCarne.isChecked()){
            String e = b.getString("edad");
            String g = b.getString("genero");
            String u = b.getString("ubicacion");

            in.putExtra("eda", e);
            in.putExtra("gener", g);
            in.putExtra("ubicacio", u);
            in.putExtra("cate", "carnes");
            in.putExtra("id", n1);
            startActivity(in);
            finish();
        } else if(rEnsalada.isChecked()){
            String e = b.getString("edad");
            String g = b.getString("genero");
            String u = b.getString("ubicacion");

            in.putExtra("eda", e);
            in.putExtra("gener", g);
            in.putExtra("ubicacio", u);
            in.putExtra("cate", "ensaladas");
            in.putExtra("id", n2);
            startActivity(in);
            finish();
        } else if(rPasta.isChecked()){
            String e = b.getString("edad");
            String g = b.getString("genero");
            String u = b.getString("ubicacion");

            in.putExtra("eda", e);
            in.putExtra("gener", g);
            in.putExtra("ubicacio", u);
            in.putExtra("cate", "pastas");
            in.putExtra("id", n3);
            startActivity(in);
            finish();
        } else{
            new AlertDialog.Builder(this).setTitle("¡Aviso!").setMessage("Seleccione un categoría").show();
        }
    }
}
