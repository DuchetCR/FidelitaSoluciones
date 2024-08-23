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
        Menu m = new Menu();
        m.setVisible(true);//hacer visible el frame
        m.setLocationRelativeTo(null);//colocarlo en el centro pantalla
    }
}
