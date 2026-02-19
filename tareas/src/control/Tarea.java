package control;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author eduardo
 */
public class Tarea {

    Conexion con;

    public Tarea() {
        con = new Conexion("tareapp.db");
    }

    public void crearNueva(JTextField txtTitulo, JTextArea txtDescripcion, JDateChooser txtFecha) {
        try {
            con.setPst(con.getCon().prepareStatement("INSERT INTO tarea(titulo, descripcion, fecha_agenda, fecha_registro, status) VALUES (?,?,?,?,0)"));
            con.getPst().setString(1, txtTitulo.getText());
            con.getPst().setString(2, txtDescripcion.getText());
            con.getPst().setString(3, fechaFormateada("MM/dd/yyyy", txtFecha.getDate().toString()));
            con.getPst().setString(4, fechaFormateada("MM/dd/yyyy"));

            con.getPst().executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private String fechaFormateada(String strFormato, String strFecha) {
        String fechaForm = null;

        try {
            SimpleDateFormat formato = new SimpleDateFormat(strFormato);
            Date fecha = new Date(strFecha);
            fechaForm = formato.format(fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fechaForm;
    }

    private String fechaFormateada(String strFormato) {
        String fechaForm = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat(strFormato);
            Date fecha = new Date(System.currentTimeMillis());
            fechaForm = formato.format(fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fechaForm;
    }

    public void consultarFechasRegistradas(JComboBox cbbFechas) {
        try {
            con.setSt(con.getCon().createStatement());
            con.setRs(con.getSt().executeQuery("SELECT DISTINCT  (t.fecha_agenda ) FROM tarea t ;"));
            while (con.getRs().next()) {                
                cbbFechas.addItem(con.getRs().getString("fecha_agenda"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
