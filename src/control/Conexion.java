package control;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author eduardo
 */
public class Conexion {

    private Connection co;
    protected PreparedStatement pst;
    protected Statement st;
    protected ResultSet rs;
    public Conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            File archivoDB = new File("tarea.db");
            String url="jdbc:sqlite:"+archivoDB.getAbsolutePath();
            co = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error"+e);
        }
    }

    public Connection getCo() {
        return co;
    }
    
}
