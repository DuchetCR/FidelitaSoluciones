package Principal;
/**
 *
 * @author DuchetCR
 */
public class Empleado {

    private String nombre;
    private String cedula;
    private int edad;
    private boolean casado;
    private double salario;

    public Empleado() {
        this.nombre = "";
        this.cedula = "";
        this.edad = 0;
        this.casado = false;
        this.salario = 0.0;
    }

    public Empleado(String nombre, String cedula, int edad, boolean casado, double salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.casado = casado;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 18 && edad <= 45) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("La edad debe estar en el rango de 18 a 45 años");
        }
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String clasificarEdad() {
        if (edad <= 21) {
            return "Principiante";
        } else if (edad >= 22 && edad <= 35) {
            return "Intermedio";
        } else {
            return "Senior";
        }
    }

    public void aumentarSalario(double porcentaje) {
        if (porcentaje < 0) {
            throw new IllegalArgumentException("El porcentaje no puede ser negativo");
        }
        double aumento = salario * (porcentaje / 100);
        salario += aumento;
    }

    @Override
    public String toString() {
        return "\nNombre: " + this.getNombre()
                + "\nCedula: " + this.getCedula()
                + "\nEdad: " + this.getEdad()
                + "\nCasado: " + (this.isCasado() ? "Sí" : "No")
                + "\nSalario: " + this.getSalario()
                + "\nClasificación: " + this.clasificarEdad();
    }

}
