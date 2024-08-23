/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author fariv
 */
public class ClaseLibros {
    private ConexionBD conexion;

    public ClaseLibros() {
        conexion = new ConexionBD();
    }

    public void leerLibros(javax.swing.JTable table) {
        conexion.leerLibros("libros", table);
    }

    public void eliminarLibroTxt(String titulo, String editorial, String anio) {
        File archivo = new File("libros.txt");
        File temp = new File("libros_temp.txt");

        try (DataInputStream in = new DataInputStream(new FileInputStream(archivo));
             DataOutputStream out = new DataOutputStream(new FileOutputStream(temp))) {
            while (true) {
                try {
                    String t = in.readUTF();
                    String e = in.readUTF();
                    String a = in.readUTF();
                    
                    if (!t.equals(titulo) || !e.equals(editorial) || !a.equals(anio)) {
                        out.writeUTF(t);
                        out.writeUTF(e);
                        out.writeUTF(a);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el libro del archivo: " + e.getMessage(),
                    "Error al Eliminar Libro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarLibro(String titulo, String editorial, String anio, javax.swing.JTable table) {
        try {
            try (DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("libros.txt", true))) {
                archivoEscritura.writeUTF(titulo);
                archivoEscritura.writeUTF(editorial);
                archivoEscritura.writeUTF(anio);
            }
            conexion.InsertarLibro(titulo, editorial, anio);
            conexion.leerLibros("libros", table);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Agregar Datos",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos: " + e.getMessage(),
                    "Error al Agregar Datos", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(),
                    "Error al Agregar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarLibro(javax.swing.JTextField tituloField, javax.swing.JTextField editorialField, 
                                javax.swing.JTextField anioField, String id, javax.swing.JTable table) {
        conexion.ActualizarLibro(tituloField, editorialField, anioField, id);
        conexion.leerLibros("libros", table);
        JOptionPane.showMessageDialog(null, "Libro actualizado correctamente.");
    }

    public void eliminarLibro(String id, String titulo, String editorial, String anio, javax.swing.JTable table) {
        conexion.EliminaRegistro("id_libro", "libros", id);
        eliminarLibroTxt(titulo, editorial, anio);
        conexion.leerLibros("libros", table);
    }
}
    

