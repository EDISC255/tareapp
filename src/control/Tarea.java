/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author eduardo
 */
public class Tarea {

    private Conexion co;
    
    /*
        
    */
    public void agregar(entidad.Tarea nueva) {
        try {
            co = new Conexion();
            co.pst = co.getCo().prepareStatement("INSERT INTO tarea (id, titulo, descripcion, fecha, status) VALUES((SELECT COUNT(ID) FROM tarea t)+1,?,?,?,?)");
            co.pst.setString(1, nueva.getTitulo());
            co.pst.setString(2, nueva.getDescripcion());
            co.pst.setString(3, fecha(nueva.getFecha()));
            co.pst.setInt(4, 0);
            co.pst.executeUpdate();
            co.pst.close();
            co.getCo().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String fecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(new Date(fecha));
    }

    public Vector consultaFecha() {
        Vector fechas = new Vector();
        int i = 0;
        try {
            co = new Conexion();
            co.st = co.getCo().createStatement();
            co.rs = co.st.executeQuery("SELECT DISTINCT (t.fecha) FROM tarea t ;");
            while (co.rs.next()) {
                fechas.add(co.rs.getString(1));
            }
            co.st.close();
            co.rs.close();
            co.getCo().close();
        } catch (Exception e) {
        }
        return fechas;
    }

    public Vector consultarPorFecha(String fecha) {
        Vector tareas = new Vector();
        int i = 0;
        try {
            co = new Conexion();
            co.pst = co.getCo().prepareStatement("SELECT t.id, t.titulo, t.status FROM tarea t WHERE t.fecha = ? ;");
            co.pst.setString(1, fecha);
            co.rs = co.pst.executeQuery();
            while (co.rs.next()) {
                tareas.add(co.rs.getString(1) + "%20" + co.rs.getString(2) + "%20" + co.rs.getString(3));
            }

        } catch (Exception e) {
        }
        return tareas;
    }

    public void eliminar(String id) {
        Vector tareas = new Vector();
        int i = 0;
        try {
            co = new Conexion();
            co.pst = co.getCo().prepareStatement("DELETE FROM tarea WHERE id = ? ;");
            co.pst.setString(1, id);
            co.pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
