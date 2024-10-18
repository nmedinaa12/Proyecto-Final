/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 * La clase EmpleadoOperativo extiende de la clase Empleado y representa a un empleado 
 * que realiza tareas operativas. Incluye información adicional como el turno 
 * en el que trabaja y el número de horas trabajadas.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 0.0.1
 * @since 2024-10-18
 * 
 */

public class EmpleadoOperativo extends Empleado {
    //Atributo
    private String area;

    public EmpleadoOperativo(String nombre, String cedula, int edad, double salario, String area) {
        super(nombre, cedula, edad, salario);
        this.area = area;
    }
    //Metodos 
    @Override
    public double calcularSalario() {
        return salario; // Salario fijo
    }

    @Override
    public String toString() {
        return super.toString() + ", Area: " + area;
    }
}

