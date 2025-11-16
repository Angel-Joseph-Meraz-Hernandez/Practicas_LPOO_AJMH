package Practica6;

public class DesarrolladorMeraz extends EmpleadoAJMH implements Bonificable03, EvaluableNoviembre, Promovible7151{
    public DesarrolladorMeraz(String nombre, double salario) {
        super(nombre, "Desarrollador", 5, salario);
    }
    public DesarrolladorMeraz(String nombre) {
        super(nombre, "Desarrollador", 50, 10000);
    }
    public DesarrolladorMeraz() {
        super("Angel Joseph Meraz Hernandez", "Desarrollador", 50, 10000);
    }

    @Override 
    public String descripcionPuesto(){
        return "El desarrollador se encarga de diseniar, programar y mantener aplicaciones o sistemas informaticos.";
    }
    @Override
    public void setSalario(double salario){
        if (salario > 10000){
            this.salario = salario;
        }
        else{
            System.out.println("Este salario es invalido.");
            this.salario = 10000;
        }
    }
    @Override
    public double calcularBono(){
        if (calificacion >= 70)
            return salario * 0.30;
        else
            return 0;
    }
    @Override 
    public void bonificar(){
        setSalario(salario + calcularBono());
    }
    @Override 
    public void evaluar(int calificacion){
        if (calificacion < 0){
            System.out.println("La calificacion debe ser un numero de 0 a 100.");
            this.calificacion = 0 ;
        }
        else if(calificacion > 100){
            System.out.println("La calificacion debe ser un numero de 0 a 100.");
            this.calificacion = 100;
        }
        else{
            this.calificacion = calificacion;
        }
    }
    public boolean promover(){
        if (calificacion >= 90)
            return true;
        else
            return false;
    };
}