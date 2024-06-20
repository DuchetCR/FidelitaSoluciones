/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author matias
 */
public class Pasante extends Empleado{
    private int duracionPasantia;
    private String universidad;
    private String carrera;

    public Pasante() {
        super();
        this.duracionPasantia = 0;
        this.universidad = "";
        this.carrera = "";
    }

    public Pasante(String nombre, String cedula, int edad, boolean casado, double salario, int duracionPasantia, String universidad, String carrera) {
        super(nombre, cedula, edad, casado, salario);
        this.duracionPasantia = duracionPasantia;
        this.universidad = universidad;
        this.carrera = carrera;
    }

    public int getDuracionPasantia() {
        return duracionPasantia;
    }

    public void setDuracionPasantia(int duracionPasantia) {
        if (duracionPasantia > 0) {
            this.duracionPasantia = duracionPasantia;
        } else {
            throw new IllegalArgumentException("La duración de la pasantía debe ser mayor a 0");
        }
    }


    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    @Override
    public String toString() {
        return super.toString()
            + "\nDuración de la Pasantía: " + this.getDuracionPasantia() + " meses"
            + "\nUniversidad: " + this.getUniversidad()
            + "\nCarrera: " + this.getCarrera();
    }
}
