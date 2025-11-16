package Practica7;
public class ClasePrincipalAJMH {
    public static void main(String[] args) {
        try {
            // Creamos el sistema
            SistemaBancoAJMH sistema = new SistemaBancoAJMH();

            System.out.println(" Validar Matriculas ");
            sistema.validarMatricula("A1234567");
            sistema.validarMatricula("123");

            System.out.println("\n Verificar Saldo ");
            sistema.verificarSaldo(1000.0, 500.0);
            sistema.verificarSaldo(200.0, 300.0);

            System.out.println("\n Buscar Usuario ");
            sistema.buscarUsuario("A123");  
            sistema.buscarUsuario("B999");  

        } catch (Exception e) {
            // Atrapa cualquier excepción inesperada
            System.out.println("Ocurrio un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
