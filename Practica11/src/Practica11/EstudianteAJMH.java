package Practica11;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class EstudianteAJMH {
    
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellidoP;
    private SimpleStringProperty apellidoM;
    private SimpleStringProperty matricula;
    private SimpleStringProperty carrera;
    private SimpleStringProperty estado;
    public static final int miMatricula = 7151;
    public static final String fecha_nacimiento = "03 noviembre";

    public EstudianteAJMH(String nombre, String apellidoP, String apellidoM, String matricula, String carrera, boolean activo) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidoP = new SimpleStringProperty(apellidoP);
        this.apellidoM = new SimpleStringProperty(apellidoM);
        this.matricula = new SimpleStringProperty(matricula);
        this.carrera = new SimpleStringProperty(carrera);
        if(activo)
            this.estado = new SimpleStringProperty("Activo");
        else
            this.estado = new SimpleStringProperty("Inactivo");
    }
    
    // Nombre
    public SimpleStringProperty getNombreProperty() {
        return nombre;
    }

    public void setNombre(String nom) {
        nombre.set(nom);
    }
    
    public String getNombre(){
        return nombre.get();
    }
    
    // Apellidos
    public SimpleStringProperty getApellidopProperty() {
        return apellidoP;
    }

    public void setApellidoP(String app) {
        apellidoP.set(app);
    }
    
    public String getApellidoP(){
        return apellidoP.get();
    }
    
    public SimpleStringProperty getApellidomProperty() {
        return apellidoM;
    }

    public void setApellidoM(String apm) {
        apellidoM.set(apm);
    }
    
    public String getApellidoM(){
        return apellidoM.get();
    }
    
    // Matricula
    public SimpleStringProperty getMatriculaProperty() {
        return matricula;
    }

    public void setMatricula(String mat) {
        matricula.set(mat);
    }
    
    public String getMatricula(){
        return matricula.get();
    }
    
    // Carrera
    public SimpleStringProperty getCarreraProperty() {
        return carrera;
    }

    public void setCarrera(String c) {
        carrera.set(c);
    }
    
    public String getCarrera(){
        return carrera.get();
    }
    
    // Estado
    public SimpleStringProperty getEstadoProperty() {
        return estado;
    }

    public void setEstado(Boolean activo) {
        if(activo)
            estado.set("Activo");
        else
            estado.set("Inactivo");
    }
    
    public String getEstado(){
        return estado.get();
    }
    
    @Override
    public String toString(){
        return "Nombre: " + nombre.get() +
                "\nApellidos: " + apellidoP.get() + " " + apellidoM.get() +
                "\nMatricula: " + matricula.get() +
                "\nCarrera: " + carrera.get() +
                "\nEstudiante activo: " + estado.get();
    }
}