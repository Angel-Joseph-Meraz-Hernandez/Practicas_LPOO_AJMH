package Practica6;

public class VendedorMeraz extends EmpleadoAJMH implements Bonificable03, EvaluableNoviembre, Promovible7151{
    public VendedorMeraz(String nombre, double salario) {
        super(nombre, "Vendedor", 5, salario);
    }
    public VendedorMeraz(String nombre) {
        super(nombre, "Vendedor", 50, 2000);
    }
    public VendedorMeraz() {
        super("Angel Joseph Meraz Hernandez", "Vendedor", 50, 10000);
    }

    @Override 
    public String descripcionPuesto(){
        return "El vendedor se dedica a ofrecer productos o servicios, atender a los clientes, resolver dudas y \ncerrar ventas.";
    }
    @Override
    public void setSalario(double salario){
        if (salario > 2000){
            this.salario = salario;
        }
        else{
            System.out.println("Este salario es invalido.");
            this.salario = 2000;
        }
    }
    @Override
    public double calcularBono(){
        if (calificacion >= 70)
            return salario * 0.20;
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
        if (calificacion >= 80)
            return true;
        else
            return false;
    };
}