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
public class EmpleadoTest {
    
    public EmpleadoTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Empleado e = new Empleado();
        e.setId(80);
        int expResult = 80;
        int result = e.getId();
        assertEquals(expResult, result);

    }


    @Test
    public void testGetRut() {
        System.out.println("getRut");
        Empleado e = new Empleado();
        e.setRut("25465482k");
        String expResult = "25465482k";
        String result = e.getRut();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Empleado e = new Empleado();
        e.setNom("Juanito Pérez");
        String expResult = "Juanito Pérez";
        String result = e.getNom();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetTel() {
        System.out.println("getTel");
        Empleado e = new Empleado();
        e.setTel("946459594");
        String expResult = "946459594";
        String result = e.getTel();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Empleado e = new Empleado();
        e.setEstado("Estado");
        String expResult = "Estado";
        String result = e.getEstado();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Empleado e = new Empleado();
        e.setUser("admin");
        String expResult = "admin";
        String result = e.getUser();
        assertEquals(expResult, result);
    }

    
}
