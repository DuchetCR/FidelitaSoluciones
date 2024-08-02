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
    public void RellenaLaTablaConDatosMySQL(String tabla, JTable visor) {
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
        String sql = "INSERT INTO libro (titulo, editorial, anio) VALUES (?, ?, ?)";
        Connection conexion = conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, titulo.getText());
            ps.setString(2, editorial.getText());
            ps.setInt(3, Integer.parseInt(anio.getText()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
