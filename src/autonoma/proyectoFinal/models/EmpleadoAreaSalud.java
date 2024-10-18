/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 * La clase EmpleadoAreaSalud extiende de la clase Empleado y representa a un empleado 
 * que trabaja en el área de la salud. Incluye información adicional como la 
 * especialidad médica y el número de horas trabajadas.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */

public class EmpleadoAreaSalud extends Empleado {
    //Atributos
    private String especialidad;
    private double numeroHorasTrabajadas;
    
    //Constructor
    public EmpleadoAreaSalud(String nombre, String cedula, String edad, double salario,
                             String especialidad, double numeroHorasTrabajadas) {
        super(nombre, cedula, edad, salario);
        this.especialidad = especialidad;
        this.numeroHorasTrabajadas = numeroHorasTrabajadas;
    }
    // Metodos de acceso
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getNumeroHorasTrabajadas() {
        return numeroHorasTrabajadas;
    }

    public void setNumeroHorasTrabajadas(double numeroHorasTrabajadas) {
        this.numeroHorasTrabajadas = numeroHorasTrabajadas;
    }

    //Metodos 
    @Override
    public double calcularSalario() {
        return (salario * 0.012) * numeroHorasTrabajadas; // 1.2% por hora trabajada
    }
}
