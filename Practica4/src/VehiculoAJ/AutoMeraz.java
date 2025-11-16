package VehiculoAJ;

public class AutoMeraz extends VehiculoBaseAJ{
    private int numeroPuertas;

    public AutoMeraz(String marca, String modelo, int anio, double precio, int numeroPuertas){
        super(marca, modelo, anio, precio);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void arrancar(){
        System.out.println("El auto " + marca + " " + modelo + " enciende su motor con llave.");
    }
    @Override
    public void detener(){
        System.out.println("El auto " + marca + " se ha estacionado correctamente.");
    }
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("El auto tiene " + numeroPuertas + " puertas abiertas.");
    }
}