package Practica1;
import java.time.LocalDate;

public class HolaMundoAJMH {
    public static void main(String[] args) {
        String nombreCompleto = "Angel Joseph Meraz Hernandez";
        String matricula = "2067151";
        final LocalDate fecha_nacimiento = LocalDate.of(2005, 11, 03);
        LocalDate fechaActual = LocalDate.now();

        System.out.println("Hola Mundo!");
        System.out.println("Nombre completo: " + nombreCompleto);
        System.out.println("Matricula: " + matricula);
        System.out.println("Fecha actual del sistema: " + fechaActual);
    }
}
