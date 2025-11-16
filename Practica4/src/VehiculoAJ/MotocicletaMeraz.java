package VehiculoAJ;

public class MotocicletaMeraz extends VehiculoBaseAJ{
    private int cilindrada;

    public MotocicletaMeraz(String marca, String modelo, int anio, double precio, int cilindrada){
        super(marca, modelo, anio, precio);
        this.cilindrada = cilindrada;
    }

    @Override
    public void arrancar(){
        System.out.println("La motocicleta " + marca + " " + modelo + " arranca con boton electrico.");
    }
    @Override
    public void detener(){
        System.out.println("La motocicleta " + marca + " se detiene suavemente con freno de disco.");
    }
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("La motocicleta hace un caballito con " + cilindrada + "cc!");
    }
}