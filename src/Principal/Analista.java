package Principal;

/**
 *
 * @author matias
 */
public class Analista extends Empleado {

    private String area;
    private String nivelDeExperiencia; //Junior, Semisenior, Senior
    private String certificaciones;

    public Analista() {
        super();
        this.area = "";
        this.nivelDeExperiencia = "";
        this.certificaciones = "";
    }

    public Analista(String nombre, String cedula, int edad, boolean casado, double salario,
            String area, String nivelDeExperiencia, String certificaciones) {
        super(nombre, cedula, edad, casado, salario);
        this.area = area;
        this.nivelDeExperiencia = nivelDeExperiencia;
        this.certificaciones = certificaciones;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNivelDeExperiencia() {
        return nivelDeExperiencia;
    }

    public void setNivelDeExperiencia(String nivelDeExperiencia) {
        this.nivelDeExperiencia = nivelDeExperiencia;
    }

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nÁrea: " + this.getArea()
                + "\nNivel de Experiencia: " + this.getNivelDeExperiencia()
                + "\nCertificaciones: " + this.getCertificaciones();
    }
}
