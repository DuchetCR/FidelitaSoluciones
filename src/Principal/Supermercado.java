package Principal;

/**
 *
 * @author Kenneth
 */
public class Supermercado {
    private int productosTotales;
    private long tiempoTotalEstancia;
    private long tiempoTotalAtencion;
    private int totalClientesAtendidos;

    public Supermercado() {
        productosTotales = 0;
        tiempoTotalEstancia = 0;
        tiempoTotalAtencion = 0;
        totalClientesAtendidos = 0;
    }

    public void agregarProductos(int productos) {
        productosTotales += productos;
    }

    public int getProductosTotales() {
        return productosTotales;
    }

    public void registrarEstancia(long tiempoEstancia) {
        tiempoTotalEstancia += tiempoEstancia;
    }

    public void registrarAtencion(long tiempoAtencion) {
        tiempoTotalAtencion += tiempoAtencion;
        totalClientesAtendidos++;
    }

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
        agregarProductos(productosComprados);
        registrarAtencion(tiempoCajas);
    }

    public double getTiempoPromedioEstancia() {
        return (double) tiempoTotalEstancia / totalClientesAtendidos;
    }

    public double getTiempoPromedioAtencion() {
        return (double) tiempoTotalAtencion / totalClientesAtendidos;
    }
}
