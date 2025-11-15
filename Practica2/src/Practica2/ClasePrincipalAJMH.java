package Practica2;

public class ClasePrincipalAJMH {
    public static void main(String[] args) {

        Universidad7151 uni = new Universidad7151(5);

        EstudianteAJMH estud1 = new EstudianteAJMH();
        EstudianteAJMH estud2 = new EstudianteAJMH("Maria Fernanda Marquez Silva", "2004937", 20, "Licenciatura en Actuaria", 3);
        EstudianteAJMH estud3 = new EstudianteAJMH("Nicolas De Jesus Fernandez Martinez", "2039401", 18);
        EstudianteAJMH estud4 = new EstudianteAJMH("Eric Morales Sanchez", "2099801", 21, "Licenciatura en Matematicas", 4);
        EstudianteAJMH estud5 = new EstudianteAJMH("Ernesto Josue Reyna Monrreal", "2061571", 19, "Licenciatura en Fisica", 2);

        uni.agregarEstudianteAJMH(estud1);
        uni.agregarEstudianteAJMH(estud2);
        uni.agregarEstudianteAJMH(estud3);
        uni.agregarEstudianteAJMH(estud4);
        uni.agregarEstudianteAJMH(estud5);
        System.out.println("\n");

        uni.mostrarTodosAJMH();
        
        String matriculaBuscada7151 = "2067151";
        if (uni.buscarPorMatriculaAJMH(matriculaBuscada7151) != null){
            System.out.println("Hay un alumno con la matricula: " + matriculaBuscada7151);
        }
        else{
            System.out.println("No existe ningun alumno con la matricula: " + matriculaBuscada7151);
        }
        System.out.println("\n");
        estud4.avanzarSemestre();
        estud2.cambiarCarrera("Licenciatura en Ciancias Computacionales");
        estud3.esMayorDeEdad();
        estud5.cumplir_anios();
    }
}
