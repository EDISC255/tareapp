/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eduardo
 */
public class Conexion {

    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    public Conexion(String rutaBD) {
        try {
            Class.forName("org.sqlite.JDBC");
            File bd = new File(rutaBD);
            con = DriverManager.getConnection("jdbc:sqlite://" + bd.getAbsolutePath());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Conexion(String URL, String usuario, String contrasena) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, usuario, contrasena);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public Statement getSt() {
        return st;
    }

}
