package Practica8;
import java.util.*;
import java.util.stream.Collectors;

public class BibliotecaAJ7151 {
    private ArrayList<Libro03Noviembre> disponibles = new ArrayList<>();
    private LinkedList<Libro03Noviembre> reservas = new LinkedList<>();
    private HashMap<String, Usuario7151> usuarios = new HashMap<>();
    private HashSet<String> categorias = new HashSet<>();
    
    
    public void agregarLibro(Libro03Noviembre l) {
        disponibles.add(l);
        categorias.add(l.getCategoria());
    }
    public boolean eliminarLibro(String titulo) {
        Iterator<Libro03Noviembre> it = disponibles.iterator();
        while (it.hasNext()) {
            Libro03Noviembre actual = it.next();
            if (actual.getTitulo().equalsIgnoreCase(titulo)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
    public List<Libro03Noviembre> buscarPorCategoria(String categoria) {
        return disponibles.stream()
                .filter(x -> x.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    public ArrayList<Libro03Noviembre> getDisponibles() {
        return disponibles;
    }

    public void ordenarPorAnio() {
        disponibles.sort(Comparator.comparingInt(Libro03Noviembre::getAnio));
    }
    
    public void reservarLibro(String titulo) {
        for (Libro03Noviembre l : disponibles) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                reservas.add(l);
                System.out.println("Libro agregado a la cola de reservas.");
                return;
            }
        }
        System.out.println("No se encontró el libro para reservar.");
    }
    
    public void atenderReserva() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
        } else {
            Libro03Noviembre atendido = reservas.poll();
            System.out.println("Reserva atendida: " + atendido);
        }
    }
    
    public void agregarUsuario(Usuario7151 u) {
        usuarios.put(u.getMatricula(), u);
    }
    
    public void iterarLibros() {
        Iterator<Libro03Noviembre> it = disponibles.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}