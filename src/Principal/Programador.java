package Principal;
/**
 *
 * @author DuchetCR
 */
public class Programador extends Empleado {

    private int lineasDeCodigoPorHora;
    private String lenguajeDominante;

    public Programador() {
        super();
        this.lineasDeCodigoPorHora = 0;
        this.lenguajeDominante = "";
    }

    public Programador(String nombre, String cedula, int edad, boolean casado, double salario, int lineasDeCodigoPorHora, String lenguajeDominante) {
        super(nombre, cedula, edad, casado, salario);
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }

    public int getLineasDeCodigoPorHora() {
        return lineasDeCodigoPorHora;
    }

    public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
    }

    public String getLenguajeDominante() {
        return lenguajeDominante;
    }

    public void setLenguajeDominante(String lenguajeDominante) {
        this.lenguajeDominante = lenguajeDominante;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nlineas de codigo por hora: " + this.getLineasDeCodigoPorHora()
                + "\nLenguaje Dominante: " + this.getLenguajeDominante();
    }
}
