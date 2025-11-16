package Practica3;

import org.junit.Test;
import static org.junit.Assert.*;

public class CuentaBancaria03NovimbreTest {
    
    public CuentaBancaria03NovimbreTest() {
    }
    
    @Test
    public void testGetNumeroCuenta() {
        System.out.println("getNumeroCuenta");
        CuentaBancaria03Novimbre instance = null;
        String expResult = "2067151";
        String result = instance.getNumeroCuenta();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSaldo method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        CuentaBancaria03Novimbre instance = null;
        double expResult = 0.0;
        double result = instance.getSaldo();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitular method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testGetTitular() {
        System.out.println("getTitular");
        CuentaBancaria03Novimbre instance = null;
        String expResult = "";
        String result = instance.getTitular();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        CuentaBancaria03Novimbre instance = null;
        boolean expResult = false;
        boolean result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroCuenta method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testSetNumeroCuenta() {
        System.out.println("setNumeroCuenta");
        String numeroCuenta = "";
        CuentaBancaria03Novimbre instance = null;
        instance.setNumeroCuenta(numeroCuenta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaldo method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testSetSaldo() {
        System.out.println("setSaldo");
        double saldo = 0.0;
        CuentaBancaria03Novimbre instance = null;
        instance.setSaldo(saldo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitular method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testSetTitular() {
        System.out.println("setTitular");
        String titular = "";
        CuentaBancaria03Novimbre instance = null;
        instance.setTitular(titular);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of desactivarCuenta method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testDesactivarCuenta() {
        System.out.println("desactivarCuenta");
        CuentaBancaria03Novimbre instance = null;
        instance.desactivarCuenta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reactivarCuenta method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testReactivarCuenta() {
        System.out.println("reactivarCuenta");
        CuentaBancaria03Novimbre instance = null;
        instance.reactivarCuenta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of depositar method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testDepositar() {
        System.out.println("depositar");
        double cantidad = 0.0;
        CuentaBancaria03Novimbre instance = null;
        instance.depositar(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retirar method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar");
        double cantidad = 0.0;
        CuentaBancaria03Novimbre instance = null;
        instance.retirar(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CuentaBancaria03Novimbre.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CuentaBancaria03Novimbre instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
