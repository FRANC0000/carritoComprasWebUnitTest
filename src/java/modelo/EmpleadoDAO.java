/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Modificado por Felipe Andrés Zavalla Vásquez
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public Empleado validar(String user, String pass) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Pass=? and Estado='Activo'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setRut(rs.getString("Rut"));
                em.setNom(rs.getString("Nombres"));
                em.setTel(rs.getString("Telefono"));
                em.setEstado(rs.getString("Estado"));
            }
        } catch (Exception e) {
            logger.warning(e.toString());
        }
        return em;
    }
    
    //Operaciones CRUD
    
    public List<Empleado> listar(){
        String sql="select * from empleado";
        List<Empleado>lista=new ArrayList<>();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setRut(rs.getString(4));
                em.setNom(rs.getString(5));
                em.setTel(rs.getString(6));
                em.setEstado(rs.getString(7));
                em.setUser(rs.getString(2));
                lista.add(em);
            }
        } catch (Exception e) {
            logger.warning(e.toString());
        }
        return lista;
    }
    public int agregar(Empleado em){ 
        String sql="insert into empleado(Rut, Nombres, Telefono,Estado,User,Pass)values(?,?,?,?,?,'1234')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getRut());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
            logger.warning(e.toString());
        }
        return r;
        
    }
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        String sql="select * from empleado where IdEmpleado=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {
                emp.setRut(rs.getString(4));
                emp.setNom(rs.getString(5));
                emp.setTel(rs.getString(6));
                emp.setEstado(rs.getString(7));
                emp.setUser(rs.getString(2));
            }
        } catch (Exception e) {
            logger.warning(e.toString());
        }
        return emp;
    }
    public int actualizar(Empleado em){
        String sql="update empleado set Rut=?, Nombres=?, Telefono=?,Estado=?,User=? where IdEmpleado=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getRut());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            logger.warning(e.toString());
        }
        return r;
    }
    public void delete(int ide){
        String sql="delete from empleado where IdEmpleado=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, ide);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.warning(e.toString());
        }
    }
    
}
