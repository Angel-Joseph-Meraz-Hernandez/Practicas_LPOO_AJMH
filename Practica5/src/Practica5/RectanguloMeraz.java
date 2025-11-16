package Practica5;

public class RectanguloMeraz extends Figura03{
    private double base;
    private double altura;

    public RectanguloMeraz(){
        super("Rectangulo");
        this.base = 1.0;
        this.altura = 1.0;
    }
    public RectanguloMeraz(double base){
        super("Rectangulo");
        this.base = base;
        this.altura = 1.0;
    }
    public RectanguloMeraz(double base, double altura){
        super("Rectangulo");
        this.base = base;
        this.altura = altura;
    }
    public RectanguloMeraz(String nombre, double base, double altura){
        super(nombre);
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea(){
        return base * altura;
    }
    @Override
    public double calcularPerimetro(){
        return (2 * base + 2 * altura);
    }
    @Override
    public String descripcion(){
        return "Mididas:\n\tBase: " + base + " unidades.\n\tAltura: " + altura + " unidades.";
    }
    
    public void cambiarRadio(double nuevaBase, double nuevaAltura){
        if (nuevaBase > 0)
            this.base = nuevaBase;
        else
            System.out.println("No se pudo establecer la nueva base, debe ser una cantidad positiva");
        if (nuevaAltura > 0)
            this.altura = nuevaAltura;
        else
            System.out.println("No se pudo establecer la nueva altura, debe ser una cantidad positiva");
    }
}
