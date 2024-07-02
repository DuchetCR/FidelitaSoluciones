package Principal;

import javax.swing.*;

/**
 * @author DuchetCR
 */
public class Principal {

    public static void main(String[] args) {
        // Crear un arreglo de empleados
        Empleado[] empleados = {
                new Empleado("Jean Ramos", "123456789", 20, true, 2500.0),
                new Programador("Perry Torres", "987654321", 30, true, 3500.0, 150, "Java"),
                new Gerente("Ramon Cortes", "589024890", 42, false, 5000.0, 30, "Recursos Humanos", 2000000),
                new Pasante("Luis Alvarez", "741258963", 22, false, 1000.0, 6, "Universidad Fidelitas", "Ingeniería de Software"),
                new Analista("Carla Mendez", "852369741", 35, true, 4000.0, "Finanzas", "Senior", new String[]{"CFA", "CPA"}),
                new Empleado("Maria Lopez", "321654987", 17, false, 3000.0)
        };

        try {
            // Aumentar salario en un 10% para todos los empleados
            for (Empleado emp : empleados) {
                emp.aumentarSalario(10);
            }

            // Mostrar información de los empleados
            for (Empleado emp : empleados) {
                JOptionPane.showMessageDialog(null, emp.toString(), "Información del empleado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
