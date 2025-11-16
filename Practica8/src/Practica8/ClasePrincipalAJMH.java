package Practica8;
import java.util.*;

public class ClasePrincipalAJMH {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BibliotecaAJ7151 biblio = new BibliotecaAJ7151();

        // Datos de prueba del estudiante
        biblio.agregarLibro(new Libro03Noviembre("Java POO", "AJMH", "Programación", 2023));
        biblio.agregarLibro(new Libro03Noviembre("Estructuras", "MHJA", "Algoritmos", 2020));
        biblio.agregarLibro(new Libro03Noviembre("POO Intermedio", "AJMH", "Programación", 2024));
        // Usuarios de prueba
        biblio.agregarUsuario(new Usuario7151("AJ7151"));
        biblio.agregarUsuario(new Usuario7151("MH2067"));
        int opcion;
        do {
            System.out.println("\nSISTEMA BIBLIOTECA AJ7151");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar por categoría");
            System.out.println("4. Ordenar libros por año");
            System.out.println("5. Registrar usuario");
            System.out.println("6. Reservar libro");
            System.out.println("7. Atender siguiente reserva");
            System.out.println("8. Mostrar libros (Iterador)");
            System.out.println("9. Medir tiempo de búsqueda por categoría");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> agregarLibro(biblio);
                case 2 -> eliminarLibro(biblio);
                case 3 -> buscarCategoria(biblio);
                case 4 -> ordenarPorAnio(biblio);
                case 5 -> registrarUsuario(biblio);
                case 6 -> reservarLibro(biblio);
                case 7 -> atenderReserva(biblio);
                case 8 -> mostrarConIterador(biblio);
                case 9 -> medirTiempo(biblio);
                case 10 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 10);
    }
    private static void agregarLibro(BibliotecaAJ7151 b) {
        System.out.print("Título: ");
        String t = sc.nextLine();
        System.out.print("Autor: ");
        String a = sc.nextLine();
        System.out.print("Categoría: ");
        String c = sc.nextLine();
        System.out.print("Año: ");
        int an = sc.nextInt();
        sc.nextLine();
        b.agregarLibro(new Libro03Noviembre(t, a, c, an));
        System.out.println("Libro agregado.");
    }
    private static void eliminarLibro(BibliotecaAJ7151 b) {
        System.out.print("Ingrese título del libro a eliminar: ");
        String titulo = sc.nextLine();
        boolean eliminado = b.eliminarLibro(titulo);

        if (eliminado)
            System.out.println("Libro eliminado.");
        else
            System.out.println("No se encontró el libro.");
    }
    private static void buscarCategoria(BibliotecaAJ7151 b) {
        System.out.print("Categoría a buscar: ");
        String cat = sc.nextLine();
        System.out.println(b.buscarPorCategoria(cat));
    }
    private static void ordenarPorAnio(BibliotecaAJ7151 b) {
        b.ordenarPorAnio();
        System.out.println("Libros ordenados por año:");
        System.out.println(b.getDisponibles());
    }
    private static void registrarUsuario(BibliotecaAJ7151 b) {
        System.out.print("Ingrese matrícula del usuario: ");
        String m = sc.nextLine();
        b.agregarUsuario(new Usuario7151(m));
        System.out.println("Usuario registrado.");
    }
    private static void reservarLibro(BibliotecaAJ7151 b) {
        System.out.print("Título del libro a reservar: ");
        String t = sc.nextLine();
        b.reservarLibro(t);
    }
    private static void atenderReserva(BibliotecaAJ7151 b) {
        b.atenderReserva();
    }
    private static void mostrarConIterador(BibliotecaAJ7151 b) {
        System.out.println("Mostrando libros con iterador:");
        b.iterarLibros();
    }
    private static void medirTiempo(BibliotecaAJ7151 b) {
        System.out.print("Categoría a medir: ");
        String categoria = sc.nextLine();
        long inicio = System.nanoTime();
        b.buscarPorCategoria(categoria);
        long fin = System.nanoTime();
        System.out.println("Tiempo de búsqueda: " + (fin - inicio) + " ns");
    }
}