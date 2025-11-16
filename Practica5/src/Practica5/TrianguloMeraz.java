package Practica5;

public class TrianguloMeraz extends Figura03{
    private double lado1;
    private double lado2;
    private double lado3;
    
    public TrianguloMeraz(){
        super("Triangulo");
        this.lado1 = 1.0;
        this.lado2 = 1.0;
        this.lado3 = 1.0;
    }
    public TrianguloMeraz(double lado1){
        super("Triangulo");
        this.lado2 = 1.0;
        this.lado3 = 1.0;
        if ((2.0 > lado1) && (lado1 + 1.0 > 1.0))
            this.lado1 = lado1;
        else{
            System.out.println("Lados incomatibles, el lado sujerido sera cambiado a 1.0");
            this.lado1 = 1.0;
        }
            
    }
    public TrianguloMeraz(double lado1, double lado2){
        super("Triangulo");
        this.lado3 = 1.0;
        if ((lado2 + 1.0 > lado1) && (lado1 + 1.0 > lado2) && (lado1 + lado2 > 1.0)){
            this.lado1 = lado1;
            this.lado2 = lado2;
        }
        else{
            System.out.println("Lados incomatibles, los lados sujeridos seran cambiados a 1.0");
            this.lado1 = 1.0;
            this.lado2 = 1.0;
        }
    }
    public TrianguloMeraz(double lado1, double lado2, double lado3){
        super("Triangulo");
        if ((lado2 + lado3 > lado1) && (lado1 + lado3 > lado2) && (lado1 + lado2 > lado3)){
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        }
        else{
            System.out.println("Lados incomatibles, los lados sujeridos seran cambiados a 1.0");
            this.lado1 = 1.0;
            this.lado2 = 1.0;
            this.lado3 = 1.0;
        }
    }
    public TrianguloMeraz(String nombre, double lado1, double lado2, double lado3){
        super(nombre);
        if ((lado2 + lado3 > lado1) && (lado1 + lado3 > lado2) && (lado1 + lado2 > lado3)){
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        }
        else{
            System.out.println("Lados incomatibles, los lados sujeridos seran cambiados a 1.0");
            this.lado1 = 1.0;
            this.lado2 = 1.0;
            this.lado3 = 1.0;
        }
    }
    
    @Override
    public double calcularArea(){
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }
    @Override
    public double calcularPerimetro(){
        return lado1 + lado2 + lado3;
    }
    @Override
    public String descripcion(){
        return "Mididas:\n\tLado 1: " + lado1 + " unidades.\n\tLado 2: " + lado2 + " unidades.\n\tLado 3: " + lado3 + " unidades.";
    }
    
    
    public void cambiarMedidas(double nuevoLado1, double nuevoLado2, double nuevoLado3){
        if (nuevoLado1 > 0) 
            this.lado1 = nuevoLado1;
        else
            System.out.println("No se pudo establecer el nuevo lado 1, debe ser una cantidad positiva");
        if (nuevoLado2 > 0) 
            this.lado2 = nuevoLado2;
        else
            System.out.println("No se pudo establecer el nuevo lado 2, debe ser una cantidad positiva");
        if (nuevoLado3 > 0) 
            this.lado3 = nuevoLado3;
        else
            System.out.println("No se pudo establecer el nuevo lado 3, debe ser una cantidad positiva");
        if ((lado2 + lado3 > lado1) && (lado2 + lado3 > lado1) && (lado1 + lado2 > lado3)){
            this.lado1 = nuevoLado1;
            this.lado2 = nuevoLado2;
            this.lado3 = nuevoLado3;
        }
        else{
            System.out.println("Lados incomatibles, los lados sujeridos seran cambiados a 1.0");
            this.lado1 = 1.0;
            this.lado2 = 1.0;
            this.lado3 = 1.0;
        }
    }
}
