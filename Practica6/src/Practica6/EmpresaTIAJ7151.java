package Practica6;
import java.util.ArrayList;
import java.util.List;

public class EmpresaTIAJ7151 {
    private List<EmpleadoAJMH> empleados = new ArrayList<>();

    public void agregarEmpleado(EmpleadoAJMH e) { 
        empleados.add(e); 
    }

    public void mostrarEmpleados() {
        for (EmpleadoAJMH e : empleados){
            e.mostrarInformacion();
            if (e instanceof DesarrolladorMeraz){
                DesarrolladorMeraz c = (DesarrolladorMeraz) e;
                if (c.promover()){
                    System.out.println("El empleado "+ c.getNombre() + " esta listo para ser promovido a gerente");
                    c.evaluar(50);
                }
            }
            if (e instanceof VendedorMeraz){
                VendedorMeraz c = (VendedorMeraz) e;
                if (c.promover()){
                    System.out.println("El empleado "+ c.getNombre() + " esta listo para ser promovido a desarrollador");
                    c.evaluar(50);
                }
                
            }
            System.out.println("==========================================================================================");
        } 
    }
}
