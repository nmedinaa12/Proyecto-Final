/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 *
 * @author user
 */
public class EmpleadoSalud extends Empleado {
    String especialidad;
    int horasTrabajadas;

    public EmpleadoSalud(String nombre, String cedula, int edad, double salario, String especialidad, int horasTrabajadas) {
        super(nombre, cedula, edad, salario);
        this.especialidad = especialidad;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * salario; // Asumiendo que salario es por hora
    }

    @Override
    public String toString() {
        return super.toString() + "," + especialidad + "," + horasTrabajadas;
    }
}