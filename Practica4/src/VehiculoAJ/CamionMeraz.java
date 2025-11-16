package VehiculoAJ;

public class CamionMeraz extends VehiculoBaseAJ{
    private double capacidadToneladas;

    public CamionMeraz(String marca, String modelo, int anio, double precio, double capacidadToneladas){
        super(marca, modelo, anio, precio);
        this.capacidadToneladas = capacidadToneladas;
    }

    @Override
    public void arrancar(){
        System.out.println("El camion " + marca + " " + modelo + " enciende su motor diesel.");
    }
    @Override
    public void detener(){
        System.out.println("El camion " + marca + " se detiene usando frenos de aire.");
    }
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("El camion puede cargar " + capacidadToneladas + " toneladas de peso.");
    }
}