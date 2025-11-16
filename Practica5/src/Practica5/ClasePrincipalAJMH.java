package Practica5;

public class ClasePrincipalAJMH{
    public static void main(String[] args){
        CirculoMeraz c1 = new CirculoMeraz(5);
        RectanguloMeraz r1 = new RectanguloMeraz(4, 6);
        TrianguloMeraz t1 = new TrianguloMeraz(3, 5, 6);
        Figura03[] figuras = { c1, r1, t1 };
        
        System.out.println("Procesando figuras con polimorfismo\n");
        CalculadoraGeometrica7151.procesarFiguras(figuras);
        
        System.out.println("\nEjemplo de instanceof y casting");
        for (Figura03 f : figuras){
            if (f instanceof CirculoMeraz){
                CirculoMeraz c = (CirculoMeraz) f;
                c.cambiarRadio(10);
                System.out.println("Radio del circulo actualizado. Nueva area: " + c.calcularArea());
            }
        }
    }
}
