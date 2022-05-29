/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import java.io.InputStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Franco
 */
public class ProductoTest {
    
    public ProductoTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Producto prod = new Producto();
        prod.setId(10);
        int expResult = 10;
        int result = prod.getId();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetNombres() {
        System.out.println("getNombres");
        ProductoDAO p = new ProductoDAO();
        Producto prod = p.buscar(8);
        String expResult = "Producto 2";
        String result = prod.getNombres();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Producto p = new Producto();
        p.setPrecio(8200);
        double expResult = 8200;
        double result = p.getPrecio();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetStock() {
        System.out.println("getStock");
        Producto prod = new Producto();
        prod.setStock(18);
        int expResult = 18;
        int result = prod.getStock();
        assertEquals(expResult, result);
    }
}
