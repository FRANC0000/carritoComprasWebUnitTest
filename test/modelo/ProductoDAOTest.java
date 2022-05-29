/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TecCalidad
 */
public class ProductoDAOTest {
    
    public ProductoDAOTest() {
    }
    
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        ProductoDAO instance = new ProductoDAO();
        String expResult = "Este es el producto 2";
        Producto p = instance.buscar(8);
        String result = p.getDescripcion();
        assertEquals(expResult, result);
    }
    
}
