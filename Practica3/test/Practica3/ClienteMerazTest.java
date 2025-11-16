package Practica3;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteMerazTest {
    
    public ClienteMerazTest() {
    }
    
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        ClienteMeraz instance = new ClienteMeraz();
        String nombre = "Joseph Meraz Hernandez";
        instance.setNombre(nombre);
        assertEquals(nombre, instance.getNombre());
    }

    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        ClienteMeraz instance = new ClienteMeraz();
        String direccion = "819 Vistas del Campo, Vistas del Rio";
        instance.setDireccion(direccion);
        assertEquals(direccion, instance.getDireccion(), 0);
    }

    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        ClienteMeraz instance = new ClienteMeraz();
        String telefono = "81 2429 9801";
        instance.setTelefono(telefono);
        assertEquals(telefono, instance.getTelefono(), 0);
    }

    @Test
    public void testMostrarInfoCliente() {
        System.out.println("mostrarInfoCliente");
        ClienteMeraz instance = new ClienteMeraz();
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        instance.mostrarInfoCliente();
        String output = outContent.toString();
        assertTrue(output.contains(instance.getNombre()));
        assertTrue(output.contains(instance.getDireccion()));
        assertTrue(output.contains(instance.getTelefono()));
    }

    @Test
    public void testRealizarDeposito() {
        System.out.println("realizarDeposito");
        ClienteMeraz instance = new ClienteMeraz();
        double cantidad = 20.0;
        double saldoInicial = instance.getCuenta().getSaldo(); // será 7151
        instance.realizarDeposito(cantidad);
        assertEquals(saldoInicial + cantidad, instance.getCuenta().getSaldo(), 0.001);
    }

    @Test
    public void testRealizarRetiro() {
        System.out.println("realizarRetiro");
        ClienteMeraz instance = new ClienteMeraz();
        double saldoInicial = instance.getCuenta().getSaldo();
        double cantidad = 500;
        instance.realizarDeposito(1000); // asegurar saldo suficiente
        instance.realizarRetiro(cantidad);
        assertEquals(saldoInicial + 1000 - cantidad, instance.getCuenta().getSaldo(), 0.001);
    }

    @Test
    public void testCerrarCuenta() {
        System.out.println("cerrarCuenta");
        ClienteMeraz instance = new ClienteMeraz();
        instance.cerrarCuenta();
        assertFalse(instance.getCuenta().getEstado());
    }

    @Test
    public void testReactivarCuenta() {
        System.out.println("reactivarCuenta");
        ClienteMeraz instance = new ClienteMeraz();
        instance.cerrarCuenta(); // primero la cerramos
        instance.reactivarCuenta();
        assertTrue(instance.getCuenta().getEstado());
    }
}