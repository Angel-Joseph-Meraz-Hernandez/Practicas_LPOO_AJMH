package Practica2;

public class EstudianteAJMH {
    private String nombre;
    private String matricula;
    private int edad;
    private String carrera;
    private int semestreActual;
    public static final int miMatricula = 7151;
    public static final String fecha_nacimiento = "03 noviembre";

    public EstudianteAJMH() {
        this.nombre = "Angel Joseph Meraz Hernandez";
        this.matricula = "2067151";
        this.edad = 20;
        this.carrera = "Licenciatura en Ciancias Computacionales";
        this.semestreActual = 5;
    }

    public EstudianteAJMH(String nombre, String matricula, int edad) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.carrera = "Sin definir";
        this.semestreActual = 1;
    }

    public EstudianteAJMH(String nombre, String matricula, int edad, String carrera, int semestreActual) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.carrera = carrera;
        this.semestreActual = semestreActual;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Matricula: " + matricula);
        System.out.println("Edad: " + edad);
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre actual: " + semestreActual + "\n");
    }

    public void avanzarSemestre() {
        if (carrera != "Sin definir" && carrera != null){
            semestreActual++;
            System.out.println(nombre + " ha avanzado al semestre " + semestreActual + "\n");
        }else{
            System.out.println("El estudiante " + nombre + " no esta inscrito a una carrera aun. \nPor lo tanto no puede avanzar de semestre.\n");
        }
        
    }

    public void cambiarCarrera(String nuevaCarrera) {
        if (nuevaCarrera != null && !nuevaCarrera.isEmpty()) {
            System.out.println(nombre + " ha cambiado de carrera a: " + nuevaCarrera);
            System.out.println("Por lo que ahora empieza en el primer semestre.\n");
            this.carrera = nuevaCarrera;
            semestreActual = 1;
        } else {
            System.out.println("Nombre de carrera inválido.\n");
        }
    }

    public void cumplir_anios() {
        edad++;
        System.out.println(nombre + " ahora tiene " + edad + " anios.\n");
    }

    public void esMayorDeEdad() {
        if (edad >= 18) {
            System.out.println(nombre + " es mayor de edad.\n");
        }
    }
    public String toBuscarMatricula() {
        return matricula;
    }
}
