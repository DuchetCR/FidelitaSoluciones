/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DuchetCR
 */
public class ConexionBD {

    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;

    //Parametros de la inicializacion de BD
    String url = "jdbc:mysql://localhost:3306/biblioteca";
    String username = "root";
    String password = "";

    private Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public void leerLibros(String tabla, JTable visor) {
        String sql = "SELECT * FROM " + tabla;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Libro");
        model.addColumn("Título");
        model.addColumn("Editorial");
        model.addColumn("Año");

        visor.setModel(model);
        String[] dato = new String[4];
        Connection conexion = conectar();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                model.addRow(dato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertarLibro(JTextField titulo, JTextField editorial, JTextField anio) {
        String sql = "INSERT INTO libros (titulo, editorial, anio) VALUES (?, ?, ?)";
        Connection conexion = conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, titulo.getText());
            ps.setString(2, editorial.getText());
            ps.setInt(3, Integer.parseInt(anio.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Libro Insertado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void EliminaRegistro(String idColumn, String tabla, String id) {
        String sql = "DELETE FROM " + tabla + " WHERE " + idColumn + " = ?";
        Connection conexion = conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ActualizarLibro(JTextField titulo, JTextField editorial, JTextField anio, String id) {
        String sql = "UPDATE libros SET titulo = ?, editorial = ?, anio = ? WHERE id_libro = ?";
        Connection conexion = conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, titulo.getText());
            ps.setString(2, editorial.getText());
            ps.setInt(3, Integer.parseInt(anio.getText()));
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void leerLectores(String tabla, JTable visor) {
        String sql = "SELECT * FROM " + tabla;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Usuario");
        model.addColumn("Nombre");
        model.addColumn("Dirección");
        model.addColumn("Teléfono");
        model.addColumn("Ciudad");
        model.addColumn("Correo");

        visor.setModel(model);
        String[] dato = new String[6];
        Connection conexion = conectar();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                dato[0] = rs.getString("id_usuario");
                dato[1] = rs.getString("nombre");
                dato[2] = rs.getString("direccion");
                dato[3] = rs.getString("telefono");
                dato[4] = rs.getString("ciudad");
                dato[5] = rs.getString("correo");
                model.addRow(dato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertarUsuario(JTextField nombre, JTextField direccion, JTextField telefono, JTextField ciudad, JTextField correo) {
        String sql = "INSERT INTO lectores (nombre, direccion, telefono, ciudad, correo) VALUES (?, ?, ?, ?, ?)";
        Connection conexion = conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre.getText());
            ps.setString(2, direccion.getText());
            ps.setString(3, telefono.getText());
            ps.setString(4, ciudad.getText());
            ps.setString(5, correo.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lector Insertado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ActualizarUsuario(JTextField nombre, JTextField direccion, JTextField telefono, JTextField ciudad, JTextField correo, String id) {
        String sql = "UPDATE lectores SET nombre = ?, direccion = ?, telefono = ?, ciudad = ?, correo = ? WHERE id_usuario = ?";
        Connection conexion = conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre.getText());
            ps.setString(2, direccion.getText());
            ps.setString(3, telefono.getText());
            ps.setString(4, ciudad.getText());
            ps.setString(5, correo.getText());
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
