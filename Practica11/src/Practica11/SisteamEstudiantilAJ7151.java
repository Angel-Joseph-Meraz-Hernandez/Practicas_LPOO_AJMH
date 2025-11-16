package Practica11;

import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SisteamEstudiantilAJ7151 {
    
    private ObservableList<EstudianteAJMH> estudiantes;

    public SisteamEstudiantilAJ7151() {
    estudiantes = FXCollections.observableArrayList();
    }
    
    public ObservableList<EstudianteAJMH> lista(){
        return estudiantes;
    }
    
    public void crearRegistro(String nombre, String apellidoP, String apellidoM, String matricula, String carrera, boolean activo){
        estudiantes.add(new EstudianteAJMH(nombre, apellidoP, apellidoM, matricula, carrera, activo));
    }
    
    public EstudianteAJMH buscarRegistro(String matricula){
        for(EstudianteAJMH est: estudiantes){
            if(est.getMatricula().equals(matricula)){
                return est;
            }
        }
        return null;
    }
    
    public void actualizarRegistro(String matricula, String nombre, String apellidoP, String apellidoM, String carrera, boolean activo){
        Iterator<EstudianteAJMH> i = estudiantes.iterator();
        while(i.hasNext()){
            EstudianteAJMH est = i.next();
            if(est.getMatricula().equals(matricula)){
                est.setNombre(nombre);
                est.setApellidoP(apellidoP);
                est.setApellidoM(apellidoM);
                est.setCarrera(carrera);
                est.setEstado(activo);
                est.setMatricula(matricula);
                return;
            }
        }
    }
    
    public void eliminarRegistro(String matricula){
        Iterator<EstudianteAJMH> i = estudiantes.iterator();
        while(i.hasNext()){
            EstudianteAJMH est = i.next();
            if(est.getMatricula().equals(matricula)){
                i.remove();
                return;
            }
        }
    }
    
    @Override
    public String toString(){
        String cadena = "";
        Iterator<EstudianteAJMH> i = estudiantes.iterator();
        while(i.hasNext()){
            EstudianteAJMH est = i.next();
            cadena += est.toString();
        }
        return cadena;
    }
    
}