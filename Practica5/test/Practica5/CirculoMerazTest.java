package Practica5;

import org.junit.Test;
import static org.junit.Assert.*;

public class CirculoMerazTest {
    
    public CirculoMerazTest() {
    }
    
    /**
     * Test of mostrarNombre method, of class CirculoMeraz.
     */
    @Test
    public void testMostrarNombre() {
        System.out.println("mostrarNombre");
        CirculoMeraz instance = new CirculoMeraz();
        instance.mostrarNombre();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularArea method, of class CirculoMeraz.
     */
    @Test
    public void testCalcularArea() {
        System.out.println("calcularArea");
        CirculoMeraz instance = new CirculoMeraz();
        double expResult = 3.1415;
        double result = instance.calcularArea();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularPerimetro method, of class CirculoMeraz.
     */
    @Test
    public void testCalcularPerimetro() {
        System.out.println("calcularPerimetro");
        CirculoMeraz instance = new CirculoMeraz();
        double expResult = 6.2830;
        double result = instance.calcularPerimetro();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of descripcion method, of class CirculoMeraz.
     */
    @Test
    public void testDescripcion() {
        System.out.println("descripcion");
        CirculoMeraz instance = new CirculoMeraz();
        String expResult = "Mididas:\n\tRadio: 1.0 unidades.";
        String result = instance.descripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of cambiarRadio method, of class CirculoMeraz.
     */
    @Test
    public void testCambiarRadio() {
        System.out.println("cambiarRadio");
        double nuevoRadio = 10.0;
        CirculoMeraz instance = new CirculoMeraz();
        instance.cambiarRadio(nuevoRadio);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
