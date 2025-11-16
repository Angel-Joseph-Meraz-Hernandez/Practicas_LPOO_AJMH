package Practica6;

public class GerenteMeraz extends EmpleadoAJMH implements Bonificable03, EvaluableNoviembre{
    public GerenteMeraz(String nombre, double salario) {
        super(nombre, "Gerente", 50, salario);
    }
    public GerenteMeraz(String nombre) {
        super(nombre, "Gerente", 50, 50000);
    }
    public GerenteMeraz() {
        super("Angel Joseph Meraz Hernandez", "Gerente", 5, 50000);
    }

    @Override 
    public String descripcionPuesto(){
        return "El gerente es responsable de supervisar las operaciones del equipo, coordinar tareas, tomar decisiones \nestrategicas y asegurar que se cumplan los objetivos de la organizacion.";
    }
    @Override
    public void setSalario(double salario){
        if (salario > 50000){
            this.salario = salario;
        }
        else{
            System.out.println("Este salario es invalido.");
            this.salario = 10000;
        }
    }
    @Override
    public double calcularBono(){
        if (calificacion >= 80)
            return salario * 0.50;
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
    
}