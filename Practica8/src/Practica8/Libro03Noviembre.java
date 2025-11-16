package Practica8;

public class Libro03Noviembre implements Comparable<Libro03Noviembre> {
    private String titulo;
    private String autor;
    private String categoria;
    private int anio;
    public static final int miMatricula = 7151;
    public static final String fecha_nacimiento = "03 noviembre";

    public Libro03Noviembre(String titulo, String autor, String categoria, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.anio = anio;
    }

    // --- GETTERS ---
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public int compareTo(Libro03Noviembre o) {
        return this.titulo.compareToIgnoreCase(o.titulo);
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + categoria + ", " + anio + ")";
    }
}