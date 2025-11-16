package Practica5;

public abstract class Figura03 implements CalculableAJ{
    protected String nombre;
    public static final int miMatricula = 7151;
    public static final String fecha_nacimiento = "03 noviembre";
    public Figura03(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre; 
    }
    public void mostrarNombre(){
        System.out.println("Figura: " + nombre); 
    }
    
    @Override 
    public abstract double calcularArea();
    @Override 
    public abstract double calcularPerimetro();
    @Override 
    public abstract String descripcion();
}
