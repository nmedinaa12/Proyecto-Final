/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 *
 * @author user
 */
public class EmpleadoOperativo extends Empleado {
    String tipoTrabajo;

    public EmpleadoOperativo(String nombre, String cedula, int edad, double salario, String tipoTrabajo) {
        super(nombre, cedula, edad, salario);
        this.tipoTrabajo = tipoTrabajo;
    }

    @Override
    public double calcularSalario() {
        return salario; // Suponiendo salario fijo
    }

    @Override
    public String toString() {
        return super.toString() + "," + tipoTrabajo;
    }
}
