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
public class ClaseLectores extends Usuario {
    private String cedula;
    private ConexionBD conexion;

    public ClaseLectores(String nombre, String direccion, String telefono, String ciudad, String correo, String cedula) {
        super(nombre, direccion, telefono, ciudad, correo);
        this.cedula = cedula;
        conexion = new ConexionBD();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void agregarLectorTxt(String nombre, String direccion, String telefono, String ciudad, String correo, String cedula) {
        try (DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("lectores.txt", true))) {
            archivoEscritura.writeUTF(nombre);
            archivoEscritura.writeUTF(direccion);
            archivoEscritura.writeUTF(telefono);
            archivoEscritura.writeUTF(ciudad);
            archivoEscritura.writeUTF(correo);
            archivoEscritura.writeUTF(cedula);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos: " + e.getMessage(),
                    "Error al Agregar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarLectorTxt(String nombre, String direccion, String telefono, String ciudad, String correo, String cedula) {
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
                    String ce = in.readUTF();

                    if (!n.equals(nombre) || !d.equals(direccion) || !t.equals(telefono) || !c.equals(ciudad) || !cor.equals(correo) || !ce.equals(cedula)) {
                        out.writeUTF(n);
                        out.writeUTF(d);
                        out.writeUTF(t);
                        out.writeUTF(c);
                        out.writeUTF(cor);
                        out.writeUTF(ce);
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

    public boolean validateInputs(String nombre, String direccion, String telefono, String ciudad, String correo, String cedula) {
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
        if (cedula.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Cedula no puede estar vacío.");
            return false;
        }
        return true;
    }

    public void agregarLector(String nombre, String direccion, String telefono, String ciudad, String correo, String cedula) {
        if (validateInputs(nombre, direccion, telefono, ciudad, correo, cedula)) {
            agregarLectorTxt(nombre, direccion, telefono, ciudad, correo, cedula);
            ClaseLectores nuevoUsuario = new ClaseLectores(nombre, direccion, telefono, ciudad, correo, cedula);
            conexion.InsertarLector(nuevoUsuario);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Agregar Datos",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarLector(int id, String nombre, String direccion, String telefono, String ciudad, String correo, String cedula) {
        conexion.EliminaRegistro("id_usuario", "lectores", String.valueOf(id));
        eliminarLectorTxt(nombre, direccion, telefono, ciudad, correo, cedula);
        JOptionPane.showMessageDialog(null, "Datos del lector eliminados correctamente", "Eliminar Datos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void actualizarLector(String id, String nombre, String direccion, String telefono, String ciudad, String correo, String cedula) {
        conexion.ActualizarLector(nombre, direccion, telefono, ciudad, correo, cedula, id);
        JOptionPane.showMessageDialog(null, "Datos del lector actualizados", "Actualizar Datos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void cargar(javax.swing.JTable table) {
        conexion.leerLectores("lectores", table);
    }
    
    @Override
    public void mostrarInformacion() {
        JOptionPane.showMessageDialog(null, 
            "Nombre: " + nombre + "\n" +
            "Dirección: " + direccion + "\n" +
            "Teléfono: " + telefono + "\n" +
            "Ciudad: " + ciudad + "\n" +
            "Correo: " + correo + "\n" +
            "Cedula: " + cedula,
            "Información del Lector", JOptionPane.INFORMATION_MESSAGE);
    }
}

    

