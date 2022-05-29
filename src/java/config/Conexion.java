/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Modificado por Felipe Andrés Zavalla Vásquez
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;

/**
 *
 * @author docencia
 */
public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/bdcarritocompras";
    String user = "root";
    String pass = "";
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(url, user, new String(Base64.getDecoder().decode(pass)));
        return con;
    }
}
