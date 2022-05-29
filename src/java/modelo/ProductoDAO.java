/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Modificado por Felipe Andrés Zavalla Vásquez
 */
package modelo;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author docencia
 */
public class ProductoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    Logger logger = Logger.getLogger(this.getClass().getName());
    List<Producto> productos;
    
    
    public Producto buscar(int id) {
        Producto p = new Producto();
        String sql = "select * from producto where idProducto=?";
        try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           p = ProductoDAO.this.runQueryProductos(ps, p);
        } catch(Exception e) {
            logger.warning(e.toString());
        }
        return p;
    }
    
    public int actualizarStock(int id, int stock) {
        String sql = "update producto set stock =? where idProducto = ?";
        try {
            con =cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch(Exception e) {
            logger.warning(e.toString());
        }
        return r;
    }
    
    public List<Producto> listar() {
        productos = new ArrayList<>();
        String sql = "select * from producto";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            productos = runQueryProductos(ps);
        } catch(Exception e){
            logger.warning(e.toString());
        }
        return productos;
    }
    
    public List<Producto> listarBuscar(String buscar) {
        productos = new ArrayList<>();
        String sql = "select * from producto where Nombres like ? or Descripcion like ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+buscar+"%");
            ps.setString(2, "%"+buscar+"%");
            productos = runQueryProductos(ps);
        } catch(Exception e){
            logger.warning(e.toString());
        }
        return productos;
    }
    
    public int agregar(Producto p){ 
        String sql="insert into producto(Nombres, Descripcion, Precio, Stock)values(?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            r = ps.executeUpdate();
        } catch (Exception e) {
            logger.warning(e.toString());
        }
        return r;
        
    }
    
    public int actualizar(Producto p){
        String sql="update producto set Nombres=?, Descripcion=?, Precio=?, Stock=? where idProducto=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getId());
            r = ps.executeUpdate();
        } catch (Exception e) {
            logger.warning(e.toString());
        }
        return r;
    }
    public void delete(int idp){
        String sql="delete from producto where IdProducto=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idp);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.warning(e.toString());
        }
    }
    
    private Producto runQueryProductos(PreparedStatement sql, Producto p) {
        try {
            rs = sql.executeQuery();
            while (rs.next()){
                p = new Producto(rs.getInt(1),rs.getString(2), rs.getBinaryStream(3), rs.getString(4),rs.getDouble(5), rs.getInt(6));
            }
        } catch(Exception e) {
            logger.warning(e.toString());
        }
        return p;
    }
    
    private List<Producto> runQueryProductos(PreparedStatement sql) {
        try {
            rs = sql.executeQuery();
            while (rs.next()){
                Producto p = new Producto(rs.getInt(1),rs.getString(2), rs.getBinaryStream(3), rs.getString(4),rs.getDouble(5), rs.getInt(6));
                productos.add(p);
            }
        } catch(Exception e) {
            logger.warning(e.toString());
        }
        return productos;
    }
    
}
