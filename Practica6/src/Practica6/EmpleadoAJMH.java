package Practica6;

public abstract class EmpleadoAJMH{
    protected String nombre;
    protected String puesto;
    protected int calificacion;
    protected double salario;
    public static final int miMatricula = 7151;
    public static final String fecha_nacimiento = "03 noviembre";
    
    public EmpleadoAJMH(){
        this.nombre = "Angel Joseph Meraz Hernandez";
        this.puesto = "Vendedor";
        this.calificacion = 50;
        this.salario = 2000;
    }
    public EmpleadoAJMH(String nombre, String puesto, int calificacion, double salario){
        setNombre(nombre);
        this.puesto = puesto;
        this.calificacion = calificacion;
        setSalario(salario);
    }
    
    public abstract String descripcionPuesto();
    
    public String getNombre(){
        return nombre;
    }
    public double getSalario(){
        return salario;
    }
    public void setNombre(String nombre){
        if (nombre != null && !nombre.isEmpty()){
            this.nombre = nombre;
        }
        else{
            System.out.println("Este nombre es invalido.");
        }
    }
    public abstract void setSalario(double salario);
    
    public void mostrarInformacion() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Puesto: " + descripcionPuesto());
        System.out.println("Salario: $" + salario);
    }
}
