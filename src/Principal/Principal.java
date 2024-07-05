package Principal;

import javax.swing.JOptionPane;

/**
 *
 * @author DuchetCR
 */
public class Principal {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        Thread[] clientes = new Thread[100];

        for (int i = 0; i < 100; i++) {
            String nombreCliente = "Cliente " + (i + 1);
            int productosComprados = (int) (Math.random() * 7);
            int pasillosVisitados = (int) (Math.random() * 6) + 8;
            Cliente cliente = new Cliente(nombreCliente, productosComprados, pasillosVisitados, supermercado);
            clientes[i] = cliente;
            cliente.start();
        }

        for (Thread cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                System.out.println("Error esperando a que los clientes terminen.");
            }
        }

        int totalProductos = supermercado.getProductosTotales();
        double tiempoPromedioEstancia = supermercado.getTiempoPromedioEstancia();
        double tiempoPromedioAtencion = supermercado.getTiempoPromedioAtencion();

        System.out.println("El total de productos adquiridos por todos los clientes es: " + totalProductos);
        System.out.println("El tiempo promedio de estancia de los clientes en el supermercado es: " + tiempoPromedioEstancia + " ms");
        System.out.println("El tiempo promedio de atención de la cajera es: " + tiempoPromedioAtencion + " ms");
    }
}
