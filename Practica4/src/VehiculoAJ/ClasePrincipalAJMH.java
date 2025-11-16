package VehiculoAJ;

public class ClasePrincipalAJMH{
    public static void main(String[] args){

        Concesionaria7151 concesionaria = new Concesionaria7151();
        
        VehiculoBaseAJ auto = new AutoMeraz("Toyota", "Corolla", 2022, 315000, 4);
        VehiculoBaseAJ moto = new MotocicletaMeraz("Yamaha", "MT-07", 2023, 210000, 689);
        VehiculoBaseAJ camion = new CamionMeraz("Volvo", "FH16", 2020, 950000, 18.0);
        
        concesionaria.agregarVehiculo(auto);
        concesionaria.agregarVehiculo(moto);
        concesionaria.agregarVehiculo(camion);
        
        concesionaria.mostrarInventario();
        
        System.out.println("\nDemostracion de polimorfismo");
        concesionaria.probarVehiculos();
    }
}
