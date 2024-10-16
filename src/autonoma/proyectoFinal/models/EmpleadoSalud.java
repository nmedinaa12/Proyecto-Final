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
    private String especialidad;
    private int horasTrabajadas;

    public EmpleadoSalud(String nombre, String documentoIdentidad, int edad, double salarioBase, String especialidad, int horasTrabajadas) {
        super(nombre, documentoIdentidad, edad, salarioBase);
        this.especialidad = especialidad;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (horasTrabajadas * 20); // Ejemplo de cálculo
    }

    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad + ", Horas Trabajadas: " + horasTrabajadas;
    }
}

// Clase EmpleadoOperativo
class EmpleadoOperativo extends Empleado {
    private String departamento;

    public EmpleadoOperativo(String nombre, String documentoIdentidad, int edad, double salarioBase, String departamento) {
        super(nombre, documentoIdentidad, edad, salarioBase);
        this.departamento = departamento;
    }

    @Override
    public double calcularSalario() {
        return salarioBase; // Salario base para empleados operativos
    }

    @Override
    public String toString() {
        return super.toString() + ", Departamento: " + departamento;
    }
}
