/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Franco
 */
public class CarritoTest {
    
    public CarritoTest() {
    }

    @Test
    public void testGetItem() {
        System.out.println("getItem");
        Carrito c = new Carrito();
        c.setItem(1);
        int expResult = 1;
        int result = c.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIdProducto() {
        System.out.println("getIdProducto");
        Carrito c = new Carrito();
        c.setIdProducto(7);
        int expResult = 7;
        int result = c.getIdProducto();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNombres() {
        System.out.println("getNombres");
        Carrito c = new Carrito();
        c.setNombres("carrito");
        String expResult = "carrito";
        String result = c.getNombres();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Carrito c = new Carrito();
        c.setDescripcion("este es un carrito");
        String expResult = "este es un carrito";
        String result = c.getDescripcion();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrecioCompra() {
        System.out.println("getPrecioCompra");
        Carrito c = new Carrito();
        c.setPrecioCompra(9.780);
        double expResult = 9.780;
        double result = c.getPrecioCompra();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Carrito c = new Carrito();
        c.setCantidad(28);
        int expResult = 28;
        int result = c.getCantidad();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSubTotal() {
        System.out.println("getSubTotal");
        Carrito c = new Carrito();
        c.setCantidad(2);
        c.setPrecioCompra(3.450);
        double expResult = 6.900;
        double result = c.getSubTotal();
        assertEquals(expResult, result, 0.0);
    }

}
