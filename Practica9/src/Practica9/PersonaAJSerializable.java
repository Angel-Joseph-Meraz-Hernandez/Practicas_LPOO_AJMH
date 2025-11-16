package Practica9;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonaAJSerializable implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String matricula;
    private String carrera;
    private double promedio;
    private LocalDate fechaNacimiento;
    public static final int miMatricula = 7151;
    public static final String fecha_nacimiento = "03 noviembre";

    public PersonaAJSerializable(String nombre, String matricula, String carrera, double promedio, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
        this.promedio = promedio;
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getNombre() { return nombre; }
    public String getMatricula() { return matricula; }
    public String getCarrera() { return carrera; }
    public double getPromedio() { return promedio; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    @Override
    public String toString() {
        return "PersonaAJSerializable{" +
        "nombre='" + nombre + '\'' +
        ", matricula='" + matricula + '\'' +
        ", carrera='" + carrera + '\'' +
        ", promedio=" + promedio +
        ", fechaNacimiento=" + fechaNacimiento +
        '}';
    }

    private static String escape(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\"") || s.contains("")) {
            s = s.replace("\"", "\"\"");
            return "\"" + s + "\"";
        }
        return s;
    }
    public String toCSVLine() {
        return escape(nombre) + "," + escape(matricula) + "," + escape(carrera) + "," + promedio + "," + fechaNacimiento;
    }
    
    public static PersonaAJSerializable fromCSVLine(String line) {
        List<String> cols = splitCSV(line);
        if (cols.size() < 5) return null;
        String nombre = cols.get(0);
        String matricula = cols.get(1);
        String carrera = cols.get(2);
        double promedio = Double.parseDouble(cols.get(3));
        LocalDate fecha = LocalDate.parse(cols.get(4));
        return new PersonaAJSerializable(nombre, matricula, carrera, promedio, fecha);
    }
    private static List<String> splitCSV(String line) {
        List<String> out = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                if (inQuotes && i+1 < line.length() && line.charAt(i+1) == '"') {
                    cur.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                out.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(c);
            }
        }
        out.add(cur.toString());
        return out;
    }
}
