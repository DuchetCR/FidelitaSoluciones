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
        Empleado e1 = new Empleado("Jean Ramos", "123456789", 20, true, 2500.0);
        Programador p1 = new Programador("Perry Torres", "987654321", 30, true, 3500.0, 150, "Java");

        JOptionPane.showMessageDialog(null, "\n***Empleado***\n" + e1.toString()
        + "\n\n***Programador***\n" + p1.toString());
    }
    
}
