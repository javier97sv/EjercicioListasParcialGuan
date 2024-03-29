package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ejerciciolistasparcialguan.R;

import Entidades.InfoOrden;

import java.util.List;

public class AdaptadorComida extends BaseAdapter {

    //Declaracion de variables
    private List<InfoOrden> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;
  //  int[] imagenes;     //Es para Imagen


    public List<InfoOrden> GetData(){
        return this.datasource;
    }

    //El constructor original sin img solo lleva public AdaptadorComida(Context context, int IdPlantilla, List<InfoOrden> sources)
    public AdaptadorComida(Context context, int IdPlantilla, List<InfoOrden> sources){
        this.cntx = context;
        this.IdLayoutPlantilla = IdPlantilla;
        this.datasource = sources;
       // this.imagenes = imagenes;  //Es para img
    }

    @Override
    public int getCount() {
        return this.datasource.size();
    }

    @Override
    public Object getItem(int position) {
        return this.datasource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //Validamos que no exista un formato
        ImageView imageView;
        if(convertView == null){
            //Creamos el Administrador de Layout
            LayoutInflater inflater = (LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);

            //Le damos vida al archivo xml ahora es un Layout
            convertView = inflater.inflate(this.IdLayoutPlantilla,null);

            //Buscamos los controles de nuestra plantilla
            imageView = (ImageView) convertView.findViewById(R.id.imageView);
            TextView txvGenero = convertView.findViewById(R.id.txvGenero);
            TextView txvEdad = convertView.findViewById(R.id.txvEdad);
            TextView txvComida = convertView.findViewById(R.id.txvComida);
            TextView txvUbicacion = convertView.findViewById(R.id.txvUbicacion);

            //Obtenemos el dato a mostrar
            txvGenero.setText(this.datasource.get(position).GetGenero());
            txvEdad.setText(this.datasource.get(position).GetEdad());
            txvComida.setText(this.datasource.get(position).GetComida());
            txvUbicacion.setText(this.datasource.get(position).GetUbicacion());
            imageView.setImageResource(this.datasource.get(position).GetImg());

        }
        return convertView;
    }
}
