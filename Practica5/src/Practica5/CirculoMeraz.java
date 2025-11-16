package Practica5;

public class CirculoMeraz extends Figura03 {
    private double radio;
    private static final double PI = 3.1415;
    
    public CirculoMeraz() { 
        super("Circulo"); 
        this.radio = 1.0; 
    }
    public CirculoMeraz(double radio){
        super("Circulo");
        this.radio = radio;
    }
    public CirculoMeraz(String nombre, double radio){
        super(nombre);
        this.radio = radio;
    }
    
    @Override
    public double calcularArea(){
        return PI * radio * radio;
    }
    @Override
    public double calcularPerimetro(){
        return 2 * PI * radio;
    }
    @Override
    public String descripcion(){
        return "Mididas:\n\tRadio: " + radio + " unidades.";
    }
    
    public void cambiarRadio(double nuevoRadio){
        if (nuevoRadio > 0) 
            this.radio = nuevoRadio;
        else
            System.out.println("No se pudo establecer el nuevo radio, debe ser una cantidad positiva");
    }
}
