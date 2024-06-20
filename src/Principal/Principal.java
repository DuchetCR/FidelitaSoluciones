package Principal;

import javax.swing.JOptionPane;
/**
 *
 * @author DuchetCR
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empleado[]Empleado = new Empleado[5];
        Empleado[0] = new Empleado("Jean Ramos", "123456789", 20, true, 2500.0);
        Empleado[1] = new Programador("Perry Torres", "987654321", 30, true, 3500.0, 150, "Java");
        Empleado[2] = new Gerente("Ramon Cortes", "589024890", 42, false, 5000.0, 30, "Recursos Humanos", 2000000);
        Empleado[3] = new Pasante("Luis Alvarez", "741258963", 22, false, 1000.0, 6, "Universidad XYZ", "Ingeniería de Software");
        Empleado[4] = new Analista("Carla Mendez", "852369741", 35, true, 4000.0, "Finanzas", "Senior", "CFA, CPA");
        
        JOptionPane.showMessageDialog(null, "\n***Empleado***\n" + Empleado[0].toString()
                + "\n\n***Programador***\n" + Empleado[1].toString()
                + "\n\n***Gerente***\n" + Empleado[2].toString()
                + "\n\n***Pasante***\n" + Empleado[3].toString()
                + "\n\n***Analista***\n" + Empleado[4].toString());
 }   
}