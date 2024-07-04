package Principal;

/**
 *
 * @author Kenneth
 */
public class Supermercado {
    public void pasarPorCajas(String nombreCliente, int productosComprados) {
        long tiempoCajas = 0;

        for (int i = 0; i < productosComprados; i++) {
            long tiempoProducto = (long) (Math.random() * 61) + 20; // 20 a 80 milisegundos
            tiempoCajas += tiempoProducto;
        }
        try {
            System.out.println("El cliente " + nombreCliente + " está en cajas");
            Thread.sleep(tiempoCajas);
            System.out.println(
                    "El cliente " + nombreCliente + " ha terminado de pagar en un tiempo total de " + tiempoCajas + " ms");
        } catch (InterruptedException e) {
            System.out.println("Hubo un problema al atender al cliente " + nombreCliente);
        }
    }
}