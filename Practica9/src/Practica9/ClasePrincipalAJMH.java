package Practica9;
import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

public class ClasePrincipalAJMH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<PersonaAJSerializable> demo = new ArrayList<>();
        demo.add(new PersonaAJSerializable("Ana Morales Perez", "2067001", "Licenciatura en Actuaria", 8.7, LocalDate.of(2003, 5, 11)));
        demo.add(new PersonaAJSerializable("Luis Eric Lopez Gomez", "2067002", "Licenciatura en Matematicas", 9.1, LocalDate.of(2002, 8, 23)));
        demo.add(new PersonaAJSerializable("Angel Joseph Meraz Hernandez", "2067151", "Licenciatura en Ciencias Computacionales", 9.5, LocalDate.of(2005, 11, 3)));
        GestorArchivosMeraz7151 gestor;
        try {
            gestor = new GestorArchivosMeraz7151();
            gestor.generateTestFiles();
        } catch (IOException e) {
            System.err.println("No se pudo inicializar el gestor: " + e.getMessage());
            return;
        }
        while (true) {
            System.out.println("\n GestorArchivosMeraz7151 ");
            System.out.println("1) Listar contenido del directorio samples/");
            System.out.println("2) Leer archivo de texto (samples/datos_2067151.txt)");
            System.out.println("3) Escribir archivo de texto");
            System.out.println("4) Leer archivo binario");
            System.out.println("5) Escribir archivo binario");
            System.out.println("6) Serializar persona");
            System.out.println("7) Deserializar persona");
            System.out.println("8) Procesar CSV de estudiantes");
            System.out.println("9) Crear backup automatico");
            System.out.println("10) Listar directorio logs");
            System.out.println("11) Salir");
            System.out.print("Elige opcion: ");
            String opt = sc.nextLine().trim();
            try {
                switch (opt) {

                    case "1": {
                        System.out.println(" Contenido de samples/ ");
                        List<Path> lista = gestor.listarDirectorio("GestorArchivosMeraz7151_data/samples");
                        for (Path p : lista) {
                            System.out.println(p.getFileName());
                        }
                        break;
                    }
                    case "2": {
                        List<String> content = gestor.leerArchivoTexto("GestorArchivosMeraz7151_data/samples/datos_2067151.txt");
                        System.out.println(" CONTENIDO ");
                        content.forEach(System.out::println);
                        break;
                    }
                    case "3": {
                        System.out.print("Nombre del archivo (ej: samples/mi_texto.txt): ");
                        String ruta = sc.nextLine().trim();
                        System.out.println("Escribe lineas (Enter para terminar):");
                        List<String> lines = new ArrayList<>();
                        while (true) {
                            String l = sc.nextLine();
                            if (l.isEmpty()) break;
                            lines.add(l);
                        }
                        gestor.escribirArchivoTexto("GestorArchivosMeraz7151_data/" + ruta, lines);
                        System.out.println("Archivo escrito: " + ruta);
                        break;
                    }
                    case "4": {
                        System.out.print("Ruta binaria (ej: samples/ejemplo.dat): ");
                        String rutaBin = sc.nextLine().trim();
                        byte[] leidos = gestor.leerBinario("GestorArchivosMeraz7151_data/" + rutaBin);
                        System.out.println("Leído: " + new String(leidos));
                        break;
                    }
                    case "5":{
                        System.out.print("Ruta binaria (ej: samples/ejemplo.dat): ");
                        String rutaBin = sc.nextLine().trim();
                        System.out.print("Texto a guardar como binario: ");
                        String texto = sc.nextLine();
                        gestor.escribirBinario("GestorArchivosMeraz7151_data/" + rutaBin, texto.getBytes());
                        System.out.println("Bytes escritos.");
                        break;
                    }
                    case "6": {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Matricula: ");
                        String matricula = sc.nextLine();
                        System.out.print("Carrera: ");
                        String carrera = sc.nextLine();
                        System.out.print("Promedio: ");
                        double prom = Double.parseDouble(sc.nextLine());
                        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
                        LocalDate fecha = LocalDate.parse(sc.nextLine());
                        PersonaAJSerializable p = new PersonaAJSerializable(nombre, matricula, carrera, prom, fecha);
                        String serPath = "GestorArchivosMeraz7151_data/samples/persona.ser";
                        gestor.guardarPersona(serPath, p);
                        System.out.println("Persona serializada en: " + serPath);
                        demo.add(p);
                        String rutaCSV = "GestorArchivosMeraz7151_data/samples/students.csv";
                        gestor.writePersonListToCSV(rutaCSV, demo);
                        System.out.println("CSV actualizado.");
                        break;
                    }
                    case "7": {
                        String serPath = "GestorArchivosMeraz7151_data/samples/persona.ser";
                        PersonaAJSerializable p2 = gestor.cargarPersona(serPath);
                        System.out.println("Deserializada: " + p2);
                        if (!demo.isEmpty()) {
                            demo.remove(demo.size() - 1);
                            System.out.println("Último estudiante eliminado de demo.");
                        } else {
                            System.out.println("Demo está vacío. No se puede eliminar nada.");
                        }
                        break;
                    }
                    case "8": {
                        String rutaCSV = "GestorArchivosMeraz7151_data/samples/students.csv";
                        List<PersonaAJSerializable> lista = gestor.readPersonsFromCSV(rutaCSV);
                        if (lista.isEmpty()) {
                            System.out.println("CSV vacío o inexistente, creando uno de ejemplo...");
                            gestor.writePersonListToCSV(rutaCSV, demo);
                            lista = demo;
                        }
                        System.out.println("Registros CSV:");
                        for (PersonaAJSerializable px : lista) {
                            System.out.println(px);
                        }
                        break;
                    }
                    case "9": {
                        System.out.print("Ruta relativa a respaldar (ej: samples/datos_2067151.txt): ");
                        String toBackup = sc.nextLine().trim();
                        Path b = gestor.crearBackupAutomatico("GestorArchivosMeraz7151_data/" + toBackup);
                        System.out.println("Backup creado en: " + b.toString());
                        break;
                    }
                    case "10": {
                        System.out.println(" LOGS ");
                        List<Path> logs = gestor.listarDirectorio("GestorArchivosMeraz7151_data/logs");
                        for (Path lp : logs) System.out.println(lp.getFileName());
                        break;
                    }
                    case "11":
                        System.out.println("Saliendo...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.err.println("\nERROR: " + e.getMessage());
            }
        }
    }
}
