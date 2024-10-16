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
    private String area;

    public EmpleadoOperativo(String nombre, String cedula, int edad, double salario, String area) {
        super(nombre, cedula, edad, salario);
        this.area = area;
    }

    @Override
    public double calcularSalario() {
        return salario; // Salario fijo
    }

    @Override
    public String toString() {
        return super.toString() + ", Area: " + area;
    }
}

