/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author fariv
 */
public class ClasePrestamos {
    private ConexionBD conexion;

    public ClasePrestamos() {
        conexion = new ConexionBD();
    }

    public void leerPrestamos(javax.swing.JTable table) {
        conexion.leerPrestamos("prestamos", table);
    }   

    public void eliminarPrestamoTxt(String id_libro, String id_usuario, String id_bibliotecario, String fecha_prestamo) {
        File archivo = new File("prestamos.txt");
        File temp = new File("prestamos_temp.txt");
        try (DataInputStream in = new DataInputStream(new FileInputStream(archivo));
             DataOutputStream out = new DataOutputStream(new FileOutputStream(temp))) {
            while (true) {
                try {
                    String l = in.readUTF();
                    String u = in.readUTF();
                    String b = in.readUTF();
                    String f = in.readUTF();
                    if (!l.equals(id_libro) || !u.equals(id_usuario) || !b.equals(id_bibliotecario) || !f.equals(fecha_prestamo)) {
                        out.writeUTF(l);
                        out.writeUTF(u);
                        out.writeUTF(b);
                        out.writeUTF(f);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el préstamo: " + e.getMessage(),
                    "Error al Eliminar Préstamo", JOptionPane.ERROR_MESSAGE);
        }
        if (archivo.delete()) {
            temp.renameTo(archivo);
        }
    }
    
    public void agregarPrestamo(String id_libro, String id_usuario, String id_bibliotecario, String fecha_prestamo, JTable table) {
    try {
        // Verificar si el libro existe en la base de datos
        boolean libroExiste = conexion.existeLibro(Integer.parseInt(id_libro));
        if (!libroExiste) {
            JOptionPane.showMessageDialog(null, "El libro con ID " + id_libro + " no existe.", "Error al Agregar Préstamo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar si el usuario existe en la base de datos
        boolean usuarioExiste = conexion.existeLector(Integer.parseInt(id_usuario));
        if (!usuarioExiste) {
            JOptionPane.showMessageDialog(null, "El lector con ID " + id_usuario + " no existe.", "Error al Agregar Préstamo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verificar si el usuario existe en la base de datos
        boolean bibliotecarioExiste = conexion.existeBibliotecario(Integer.parseInt(id_bibliotecario));
        if (!bibliotecarioExiste) {
            JOptionPane.showMessageDialog(null, "El bibliotecario con ID " + id_bibliotecario + " no existe.", "Error al Agregar Préstamo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Si ambos existen, procedemos a agregar el préstamo
        try (DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("prestamos.txt", true))) {
            archivoEscritura.writeUTF(id_libro);
            archivoEscritura.writeUTF(id_usuario);
            archivoEscritura.writeUTF(id_bibliotecario);
            archivoEscritura.writeUTF(fecha_prestamo);
            conexion.InsertarPrestamo(Integer.parseInt(id_libro), Integer.parseInt(id_usuario), Integer.parseInt(id_bibliotecario), fecha_prestamo);

            // Eliminar el libro y el lector de la base de datos
            conexion.eliminarLibroPorId(Integer.parseInt(id_libro));
//            conexion.eliminarLectorPorId(Integer.parseInt(id_usuario));

            // Actualizar la tabla de préstamos
            conexion.leerPrestamos("prestamos", table);
            JOptionPane.showMessageDialog(null, "Préstamo guardado y entidades eliminadas correctamente.", "Agregar Préstamo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al agregar el préstamo: " + e.getMessage(),
                "Error al Agregar Préstamo", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(),
                "Error al Agregar Préstamo", JOptionPane.ERROR_MESSAGE);
    }
}

    public void eliminarPrestamo(String id_libro, String id_usuario, String id_bibliotecario, String fecha_prestamo, JTable table) {
        conexion.EliminaRegistro("prestamos", id_libro, id_usuario, id_bibliotecario, fecha_prestamo);
        eliminarPrestamoTxt(id_libro, id_usuario, id_bibliotecario, fecha_prestamo);
        conexion.leerPrestamos("prestamos", table);
        JOptionPane.showMessageDialog(null, "Préstamo eliminado correctamente.");
    }
}
