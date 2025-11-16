package VehiculoAJ;
import java.util.ArrayList;
import java.util.List;

public class Concesionaria7151{
    List<VehiculoBaseAJ> inventario = new ArrayList<>();

    public void agregarVehiculo(VehiculoBaseAJ v){
        inventario.add(v);
    }

    public void mostrarInventario(){
        System.out.println("\nInventario de la Concesionaria 7151");
        for (VehiculoBaseAJ v : inventario){
            if (v != null){
                v.mostrarInformacion();
                System.out.println("----------------------------------------");
            }
        }
    }
    
    public void probarVehiculos() {
        for (VehiculoBaseAJ v : inventario) {
            v.arrancar();
            v.detener();
        }
    }
}
