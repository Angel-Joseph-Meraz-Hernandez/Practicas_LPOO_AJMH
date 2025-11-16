package Practica5;

public class CalculadoraGeometrica7151 {
    public static void mostrarCalculos(Figura03 figura) {
        figura.mostrarNombre();
        System.out.println(figura.descripcion());
        System.out.println("Area: " + figura.calcularArea() + " unidades cuadradas");
        System.out.println("Perimetro: " + figura.calcularPerimetro() + " unidades");
        System.out.println("========================================");
    }
    
    public static void procesarFiguras(Figura03[] figuras) {
        for (Figura03 f : figuras) {
            mostrarCalculos(f);
        }
    }
}
