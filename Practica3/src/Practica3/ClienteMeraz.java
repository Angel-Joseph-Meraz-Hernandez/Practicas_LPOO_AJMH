package Practica3;

public class ClienteMeraz {
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected CuentaBancaria03Novimbre cuenta;
    public static final int miMatricula = 7151;
    public static final String fecha_nacimiento = "03 noviembre";
    
    public ClienteMeraz() {
        String NombreDefectoAJMH = "Angel Joseph Meraz Hernandez";
        setNombre(NombreDefectoAJMH);
        setDireccion("819 Vistas del Campo, Vistas del Rio,76276");
        setTelefono("55-9801-9801");
        this.cuenta = new CuentaBancaria03Novimbre("", 0, NombreDefectoAJMH);
    }
    public ClienteMeraz(String nombre, String direccion, String telefono, String numCuenta, double saldoIniciado) {
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        this.cuenta = new CuentaBancaria03Novimbre(numCuenta, saldoIniciado, nombre);
    }
    
    public void setNombre(String nombre){
        if (nombre != null && !nombre.isEmpty()){
            this.nombre = nombre;
        }
        else{
            System.out.println("Este nombre es invalido.");
        }
    }
    public void setDireccion(String direccion){
        if (direccion != null && !direccion.isEmpty()){
            this.direccion = direccion;
        }
        else{
            System.out.println("Direccion sin especificar.");
        }
    }
    public void setTelefono(String telefono){
        if (telefono != null && !telefono.isEmpty()){
            this.telefono = telefono;
        }
        else{
            System.out.println("Telefono sin especificaar.");
        }
    }
    
    public void mostrarInfoCliente() {
        System.out.println("Cliente: " + nombre);
        System.out.println("Direccion: " + direccion);
        System.out.println("Telefono: " + telefono);
        System.out.println("Detalles de la cuenta:");
        System.out.println(cuenta.toString());
    }
    public void realizarDeposito(double cantidad) { 
        cuenta.depositar(cantidad); 
    }
    public void realizarRetiro(double cantidad) { 
        cuenta.retirar(cantidad); 
    }
    public void cerrarCuenta() { 
        cuenta.desactivarCuenta(); 
        System.out.println("La cuenta ha sido desactivada, ya no puede hacer movimientos en ella."); 
    }
    public void reactivarCuenta() { 
        cuenta.reactivarCuenta(); 
        System.out.println("La cuenta ha sido reactivada, ya puede hacer movimientos en ella."); 
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public CuentaBancaria03Novimbre getCuenta() {
        return cuenta;
    }
}