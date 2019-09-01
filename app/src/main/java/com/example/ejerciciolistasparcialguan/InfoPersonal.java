package com.example.ejerciciolistasparcialguan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class InfoPersonal extends AppCompatActivity {

    RadioButton rFemenino, rMasculino;
    EditText edtEdad, edtUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_personal);

        rFemenino = findViewById(R.id.rFemenino);
        rMasculino = findViewById(R.id.rMasculino);
        edtEdad = findViewById(R.id.edtEdad);
        edtUbicacion = findViewById(R.id.edtUbicacion);
    }

    public void OnClickElegirCategoria(View v){
        Intent in = new Intent(this, Categoria.class);
        if(rFemenino.isChecked() || rMasculino.isChecked()){
            if(edtEdad.getText().toString().isEmpty() && edtUbicacion.getText().toString().isEmpty()){
                new AlertDialog.Builder(this).setTitle("¡Aviso!").setMessage("Ingrese la edad y la ubicación").show();
            } else if(edtEdad.getText().toString().isEmpty()){
                new AlertDialog.Builder(this).setTitle("¡Aviso!").setMessage("Ingrese la edad").show();
            } else if(edtUbicacion.getText().toString().isEmpty()){
                new AlertDialog.Builder(this).setTitle("¡Aviso!").setMessage("Ingrese la ubicación").show();
            } else{
                if(rFemenino.isChecked()){
                    in.putExtra("genero", "Femenino");
                } else{
                    in.putExtra("genero", "Masculino");
                }

                in.putExtra("edad", edtEdad.getText().toString());
                in.putExtra("ubicacion", edtUbicacion.getText().toString());

                startActivity(in);

                finish();
            }
        }else{
            new AlertDialog.Builder(this).setTitle("¡Aviso!").setMessage("Seleccione un género").show();
        }
    }
}
