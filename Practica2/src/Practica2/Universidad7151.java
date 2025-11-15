package Practica2;

public class Universidad7151 {
    private EstudianteAJMH[] estudiantes;
    private int contador;
    
    public Universidad7151(int capacidad) {
        estudiantes = new EstudianteAJMH[capacidad];
        contador = 0;
    }
    
    public void agregarEstudianteAJMH (EstudianteAJMH e) {
        if (contador < estudiantes.length) {
            estudiantes[contador] = e;
            contador++;
            System.out.println("El estudiante " + e.toBuscarMatricula() + " fue agregado correctamente.");
        } else {
            System.out.println("No se pueden agregar más estudiantes.");
        }
    }
    public EstudianteAJMH buscarPorMatriculaAJMH (String matricula) {
        for (EstudianteAJMH e : estudiantes) {
            if (e != null && e.toBuscarMatricula().contains(matricula)) {
                return e;
            }
        }
        return null;
    }
    public void mostrarTodosAJMH () {
        System.out.println("Lista de estudiantes registrados");
        for (EstudianteAJMH e : estudiantes) {
            if (e != null) {
                e.mostrarDatos();
            }
        }
    }
}
