/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author fariv
 */
public class Gerente extends Empleado {

    private int empleadosAsignados;
    private String departamento;
    private int presupuesto;
    
    public Gerente() {
        super();
        this.empleadosAsignados = 0;
        this.departamento = "";
        this.presupuesto = 0;
    }
    public Gerente(String nombre, String cedula, int edad, boolean casado, double salario, int empleadosAsignados, String departamento, int presupuesto){
        super(nombre, cedula, edad, casado, salario);
        this.empleadosAsignados = empleadosAsignados;
        this.departamento = departamento;
        this.presupuesto = presupuesto;
    }
   public int getEmpleadosAsignados() {
        return empleadosAsignados;
    }

    public void setEmpleadosAsignados(int empleadosAsignados) {
        this.empleadosAsignados = empleadosAsignados;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }


    @Override
    public String toString() {
        return super.toString()
                + "\nEmpleados asignados: " + this.getEmpleadosAsignados()
                + "\nDepartamento a cargo: " + this.getDepartamento()
                + "\nPresupuesto asignado: " + this.getPresupuesto();
    }
}
