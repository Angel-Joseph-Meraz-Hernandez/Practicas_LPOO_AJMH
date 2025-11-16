package VehiculoAJ;

public class VehiculoBaseAJ{
    protected String marca;
    protected String modelo;
    protected int anio;
    protected double precio;
    public static final int miMatricula = 7151;
    public static final String fecha_nacimiento = "03 noviembre";

    public VehiculoBaseAJ(String marca, String modelo, int anio, double precio){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    public void mostrarInformacion(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Anio: " + anio);
        System.out.println("Precio: $" + precio);
    }
    public void arrancar(){
        System.out.println(marca + " " + modelo + " esta arrancando...");
    }
    public void detener(){
        System.out.println(marca + " " + modelo + " se ha detenido.");
    }
}