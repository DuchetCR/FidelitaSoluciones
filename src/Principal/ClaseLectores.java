/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;
import javax.swing.JOptionPane;
import java.io.*;
/**
 *
 * @author fariv
 */
public class ClaseLectores {
    private ConexionBD conexion;

    public ClaseLectores() {
        conexion = new ConexionBD();
    }

    public void agregarLectorTxt(String nombre, String direccion, String telefono, String ciudad, String correo) {
        try (DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("lectores.txt", true))) {
            archivoEscritura.writeUTF(nombre);
            archivoEscritura.writeUTF(direccion);
            archivoEscritura.writeUTF(telefono);
            archivoEscritura.writeUTF(ciudad);
            archivoEscritura.writeUTF(correo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos: " + e.getMessage(),
                    "Error al Agregar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarLectorTxt(String nombre, String direccion, String telefono, String ciudad, String correo) {
        File archivo = new File("lectores.txt");
        File temp = new File("lectores_temp.txt");

        try (DataInputStream in = new DataInputStream(new FileInputStream(archivo));
             DataOutputStream out = new DataOutputStream(new FileOutputStream(temp))) {

            while (true) {
                try {
                    String n = in.readUTF();
                    String d = in.readUTF();
                    String t = in.readUTF();
                    String c = in.readUTF();
                    String cor = in.readUTF();

                    if (!n.equals(nombre) || !d.equals(direccion) || !t.equals(telefono) || !c.equals(ciudad) || !cor.equals(correo)) {
                        out.writeUTF(n);
                        out.writeUTF(d);
                        out.writeUTF(t);
                        out.writeUTF(c);
                        out.writeUTF(cor);
                    }
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el lector del archivo: " + e.getMessage(),
                    "Error al Eliminar Lector", JOptionPane.ERROR_MESSAGE);
        }

        if (!archivo.delete()) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo original.",
                    "Error al Eliminar Archivo", JOptionPane.ERROR_MESSAGE);
        }
        if (!temp.renameTo(archivo)) {
            JOptionPane.showMessageDialog(null, "No se pudo renombrar el archivo temporal.",
                    "Error al Renombrar Archivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean validateInputs(String nombre, String direccion, String telefono, String ciudad, String correo) {
        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Nombre no puede estar vacío.");
            return false;
        }
        if (direccion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Dirección no puede estar vacío.");
            return false;
        }
        if (telefono.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Teléfono no puede estar vacío.");
            return false;
        }
        if (ciudad.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Ciudad no puede estar vacío.");
            return false;
        }
        if (correo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Correo no puede estar vacío.");
            return false;
        }
        if (!correo.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.");
            return false;
        }
        return true;
    }

    public void agregarLector(String nombre, String direccion, String telefono, String ciudad, String correo) {
        if (validateInputs(nombre, direccion, telefono, ciudad, correo)) {
            agregarLectorTxt(nombre, direccion, telefono, ciudad, correo);
            conexion.InsertarUsuario(nombre, direccion, telefono, ciudad, correo);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Agregar Datos",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarLector(int id, String nombre, String direccion, String telefono, String ciudad, String correo) {
        conexion.EliminaRegistro("id_usuario", "lectores", String.valueOf(id));
        eliminarLectorTxt(nombre, direccion, telefono, ciudad, correo);
        JOptionPane.showMessageDialog(null, "Datos del lector eliminados correctamente", "Eliminar Datos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void actualizarLector(String id, String nombre, String direccion, String telefono, String ciudad, String correo) {
        conexion.ActualizarUsuario(nombre, direccion, telefono, ciudad, correo, id);
        JOptionPane.showMessageDialog(null, "Datos del lector actualizados", "Actualizar Datos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void cargarLectores(javax.swing.JTable table) {
        conexion.leerLectores("lectores", table);
    }
}

    

