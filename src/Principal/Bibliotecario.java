/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;
import javax.swing.JOptionPane;
import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Bibliotecario extends Usuario {
    private String codigoEmpleado;
    private ConexionBD conexion;

    public Bibliotecario(String nombre, String direccion, String telefono, String ciudad, String correo, String idEmpleado) {
        super(nombre, direccion, telefono, ciudad, correo);
        this.codigoEmpleado = idEmpleado;
        conexion = new ConexionBD();
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    
    public void agregarBibliotecarioTxt(String nombre, String direccion, String telefono, String ciudad, String correo, String codigoEmpleado) {
        try (DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("bibliotecarios.txt", true))) {
            archivoEscritura.writeUTF(nombre);
            archivoEscritura.writeUTF(direccion);
            archivoEscritura.writeUTF(telefono);
            archivoEscritura.writeUTF(ciudad);
            archivoEscritura.writeUTF(correo);
            archivoEscritura.writeUTF(codigoEmpleado);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos: " + e.getMessage(),
                    "Error al Agregar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarBibliotecarioTxt(String nombre, String direccion, String telefono, String ciudad, String correo, String codigoEmpleado) {
        File archivo = new File("bibliotecarios.txt");
        File temp = new File("bibliotecarios_temp.txt");

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

                    if (!n.equals(nombre) || !d.equals(direccion) || !t.equals(telefono) || !c.equals(ciudad) || !cor.equals(correo) || !ce.equals(codigoEmpleado)) {
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
                    "Error al Eliminar Bibliotecario", JOptionPane.ERROR_MESSAGE);
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

    public boolean validateInputs(String nombre, String direccion, String telefono, String ciudad, String correo, String codigo_empleado) {
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
        if (codigo_empleado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Codigo de Empleado no puede estar vacío.");
            return false;
        }
        return true;
    }

    public void agregarBibliotecario(String nombre, String direccion, String telefono, String ciudad, String correo, String codigoEmpleado) {
        if (validateInputs(nombre, direccion, telefono, ciudad, correo, codigoEmpleado)) {
            agregarBibliotecarioTxt(nombre, direccion, telefono, ciudad, correo, codigoEmpleado);
            Bibliotecario nuevoUsuario = new Bibliotecario(nombre, direccion, telefono, ciudad, correo, codigoEmpleado);
            conexion.InsertarBibliotecario(nuevoUsuario);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Agregar Datos",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarBibliotecario(int id, String nombre, String direccion, String telefono, String ciudad, String correo, String codigoEmpleado) {
        conexion.EliminaRegistro("id_usuario", "bibliotecarios", String.valueOf(id));
        eliminarBibliotecarioTxt(nombre, direccion, telefono, ciudad, correo, codigoEmpleado);
        JOptionPane.showMessageDialog(null, "Datos del bibliotecario eliminados correctamente", "Eliminar Datos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void actualizarBibliotecario(String id, String nombre, String direccion, String telefono, String ciudad, String correo, String codigoEmpleado) {
        conexion.ActualizarBibliotecario(nombre, direccion, telefono, ciudad, correo, codigoEmpleado, id);
        JOptionPane.showMessageDialog(null, "Datos del bibliotecario actualizados", "Actualizar Datos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void cargarBibliotecario(javax.swing.JTable table) {
        conexion.leerBibliotecarios("bibliotecarios", table);
    }
    
    @Override
    public void mostrarInformacion() {
        JOptionPane.showMessageDialog(null, 
            "Nombre: " + nombre + "\n" +
            "Dirección: " + direccion + "\n" +
            "Teléfono: " + telefono + "\n" +
            "Ciudad: " + ciudad + "\n" +
            "Correo: " + correo + "\n" +
            "Codigo Empleado: " + codigoEmpleado, 
            "Información del Bibliotecario", JOptionPane.INFORMATION_MESSAGE);
    }

    // Métodos específicos para bibliotecarios
}
