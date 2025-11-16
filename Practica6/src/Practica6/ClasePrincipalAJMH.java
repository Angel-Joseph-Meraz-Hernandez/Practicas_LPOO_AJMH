package Practica6;

public class ClasePrincipalAJMH {
    public static void main(String[] args) {

        EmpresaTIAJ7151 empre = new EmpresaTIAJ7151();

        VendedorMeraz estud1 = new VendedorMeraz();
        GerenteMeraz estud2 = new GerenteMeraz("Maria Fernanda Marquez Silva", 55000);
        DesarrolladorMeraz estud3 = new DesarrolladorMeraz("Nicolas De Jesus Fernandez Martinez",30000);
        

        empre.agregarEmpleado(estud1);
        empre.agregarEmpleado(estud2);
        empre.agregarEmpleado(estud3);
        System.out.println("\n");

        empre.mostrarEmpleados();
        
        
    }
}
