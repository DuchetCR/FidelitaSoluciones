package Principal;

/**
 *
 * @author Kenneth
 */
public class Cliente extends Thread {
    private String nombre;
    private int productosComprados;
    private Supermercado supermercado;
    private int pasillosVisitados;
    private long tiempoTotalEstancia;

    public Cliente(String nombre, int productosComprados, int pasillosVisitados, Supermercado supermercado) {
        this.nombre = nombre;
        this.productosComprados = productosComprados;
        this.pasillosVisitados = pasillosVisitados;
        this.supermercado = supermercado;
    }

    @Override
    public void run() {
        try {
            long tiempoLlegada = (long) (Math.random() * 301) + 300;
            Thread.sleep(tiempoLlegada);

            long tiempoEntrada = System.currentTimeMillis();

            for (int i = 0; i < pasillosVisitados; i++) {
                long tiempoPasillo = (long) (Math.random() * 201) + 100;
                Thread.sleep(tiempoPasillo);
            }

            supermercado.pasarPorCajas(nombre, productosComprados);

            long tiempoSalida = System.currentTimeMillis();
            tiempoTotalEstancia = tiempoSalida - tiempoEntrada;
            supermercado.registrarEstancia(tiempoTotalEstancia);
        } catch (InterruptedException e) {
            System.out.println("El cliente " + nombre + " fue interrumpido.");
        }
    }

    public long getTiempoTotalEstancia() {
        return tiempoTotalEstancia;
    }
}

