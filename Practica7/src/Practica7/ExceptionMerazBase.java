package Practica7;

public class ExceptionMerazBase extends Exception{
    private String mensaje;
    public static final int miMatricula = 7151;
    public static final String fecha_nacimiento = "03 noviembre";

    public ExceptionMerazBase(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
