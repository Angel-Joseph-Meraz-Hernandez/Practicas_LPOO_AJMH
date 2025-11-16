package Practica9;
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GestorArchivosMeraz7151 {
    private static final String BACKUP_DIR = "GestorArchivosMeraz7151_data" + File.separator + "backups";
    private static final String LOGS_DIR = "GestorArchivosMeraz7151_data" + File.separator + "logs";
    private static final String SAMPLES_DIR = "GestorArchivosMeraz7151_data" + File.separator + "samples";
    private static final String CSV_LOG = LOGS_DIR + File.separator + "log_Meraz.csv";
    private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    
    public GestorArchivosMeraz7151() throws IOException {
        crearDirectorioIfNotExists(BACKUP_DIR);
        crearDirectorioIfNotExists(LOGS_DIR);
        crearDirectorioIfNotExists(SAMPLES_DIR);
        Path log = Paths.get(CSV_LOG);
        if (!Files.exists(log)) {
            Files.createDirectories(log.getParent());
            Files.write(log, Collections.singletonList("timestamp,action,target,notes"), StandardOpenOption.CREATE);
        }
    }
    public static void crearDirectorioIfNotExists(String ruta) {
        try {
            Files.createDirectories(Paths.get(ruta));
        } catch (IOException e) {
            System.err.println("No se pudo crear directorio '" + ruta + "': " + e.getMessage());
        }
    }
    public void escribirArchivoTexto(String nombreArchivo, List<String> lineas) throws IOException {
        Path p = Paths.get(nombreArchivo);
        Files.createDirectories(p.getParent() == null ? p.getParent() : p.getParent());
        Files.write(p, lineas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        appendLog("writeText", nombreArchivo, "lines=" + lineas.size());
    }
    public List<String> leerArchivoTexto(String nombreArchivo) throws IOException {
        Path p = Paths.get(nombreArchivo);
        List<String> lines = Files.readAllLines(p);
        appendLog("readText", nombreArchivo, "lines=" + lines.size());
        return lines;
    }
    public void escribirBinario(String nombreArchivo, byte[] datos) throws IOException {
        Path p = Paths.get(nombreArchivo);
        Files.createDirectories(p.getParent());
        Files.write(p, datos, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        appendLog("writeBinary", nombreArchivo, "bytes=" + datos.length);
    }
    public byte[] leerBinario(String nombreArchivo) throws IOException {
        Path p = Paths.get(nombreArchivo);
        byte[] data = Files.readAllBytes(p);
        appendLog("readBinary", nombreArchivo, "bytes=" + data.length);
        return data;
    }
    public List<Path> listarDirectorio(String ruta) throws IOException {
        Path dir = Paths.get(ruta);
        if (!Files.exists(dir) || !Files.isDirectory(dir)) return Collections.emptyList();
        List<Path> out = new ArrayList<>();
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
            for (Path p : ds) out.add(p);
        }
        appendLog("listDir", ruta, "count=" + out.size());
        return out;
    }
    public void guardarPersona(String archivo, PersonaAJSerializable persona) throws IOException {
        Path p = Paths.get(archivo);
        Files.createDirectories(p.getParent());
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(p)))) {
            oos.writeObject(persona);
        }
        appendLog("serialize", archivo, persona.getClass().getSimpleName());
    }
    public PersonaAJSerializable cargarPersona(String archivo) throws IOException, ClassNotFoundException {
        Path p = Paths.get(archivo);
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(p)))) {
            PersonaAJSerializable persona = (PersonaAJSerializable) ois.readObject();
            appendLog("deserialize", archivo, persona.getClass().getSimpleName());
            return persona;
        }
    }
    public void writePersonListToCSV(String archivo, List<PersonaAJSerializable> personas) throws IOException {
        Path p = Paths.get(archivo);
        Files.createDirectories(p.getParent());
        List<String> lines = new ArrayList<>();
        lines.add("nombre,matricula,carrera,promedio,fechaNacimiento");
        for (PersonaAJSerializable per : personas) lines.add(per.toCSVLine());
        Files.write(p, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        appendLog("writeCSV", archivo, "records=" + personas.size());
    }
    public List<PersonaAJSerializable> readPersonsFromCSV(String archivo) throws IOException {
        Path p = Paths.get(archivo);
        List<PersonaAJSerializable> out = new ArrayList<>();
        if (!Files.exists(p)) return out;
        List<String> lines = Files.readAllLines(p);
        for (String l : lines) {
            if (l.trim().isEmpty()) continue;
            if (l.toLowerCase().startsWith("nombre")) continue; // skip header
            PersonaAJSerializable per = PersonaAJSerializable.fromCSVLine(l);
            if (per != null) out.add(per);
        }
        appendLog("readCSV", archivo, "records=" + out.size());
        return out;
    }
    public Path crearBackupAutomatico(String archivoOriginal) throws IOException {
        Path src = Paths.get(archivoOriginal);
        if (!Files.exists(src)) throw new FileNotFoundException("Fuente no encontrada: " + archivoOriginal);
        String ts = LocalDateTime.now().format(TIMESTAMP);
        String filename = src.getFileName().toString();
        String backupName = filename + "_backup_" + ts;
        Path dest = Paths.get(BACKUP_DIR).resolve(backupName);
        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
        appendLog("backup", archivoOriginal, dest.toString());
        return dest;
    }
    public void generateTestFiles() throws IOException {
        Path datos = Paths.get(SAMPLES_DIR, "datos_2067151.txt");
        List<String> sample = Arrays.asList(
            "Nombre: Angel Joseph Meraz Hernandez",
            "Matricula: 2067151",
            "Carrera: Licenciatura en Ciancias Computacionales",
            "Promedio: 9.2"
        );
        Files.write(datos, sample, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        appendLog("generateSample", datos.toString(), "lines=" + sample.size());
        Path backupStatic = Paths.get(BACKUP_DIR, "backup_03Noviembre.dat");
        byte[] dummy = ("Backup estático de ejemplo - 03Noviembre - " + LocalDateTime.now()).getBytes();
        Files.write(backupStatic, dummy, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        appendLog("generateSample", backupStatic.toString(), "bytes=" + dummy.length);
        appendLog("generateSample", CSV_LOG, "ensured");
    }
    private void appendLog(String action, String target, String notes) {
        String ts = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String line = ts + "," + action + "," + quoteIfNeeded(target) + "," + quoteIfNeeded(notes);
        try {
            Files.write(Paths.get(CSV_LOG), Collections.singletonList(line), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("No se pudo escribir en log: " + e.getMessage());
        }
    }
    private String quoteIfNeeded(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("") || s.contains("\"")) {
            return '"' + s.replace("\"", "\"\"") + '"';
        }
        return s;
    }
}