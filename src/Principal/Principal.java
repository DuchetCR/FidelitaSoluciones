package Principal;

/**
 *
 * @author DuchetCR
 */
public class Principal {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();

        for (int i = 0; i < 100; i++) {
            String nombreCliente = "Cliente " + (i + 1);
            int productosComprados = (int) (Math.random() * 7);
            int pasillosVisitados = (int) (Math.random() * 6) + 8;
            Cliente cliente = new Cliente(nombreCliente, productosComprados, pasillosVisitados, supermercado);
            cliente.start();
        }
    }
}
