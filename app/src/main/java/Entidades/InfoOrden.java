package Entidades;

public class InfoOrden {
    //Declaramos los atributos
    private String genero;
    private String edad;
    private String ubicacion;
    private String comida;

    //Declaramos los metodos de acceso
    public void SetGenero(String value){
        this.genero = value;
    }
    public  String GetGenero(){
        return this.genero;
    }
    public void SetEdad(String value){
        this.edad = value;
    }
    public String GetEdad(){
        return this.edad;
    }
    public void SetUbicacion(String value){
        this.ubicacion = value;
    }
    public  String GetUbicacion(){
        return this.ubicacion;
    }
    public void SetComida(String value){
        this.comida = value;
    }
    public String GetComida(){
        return this.comida;
    }
}
