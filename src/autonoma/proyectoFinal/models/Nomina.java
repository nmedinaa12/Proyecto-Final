/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.util.List;

/**
 * Registro de los empleados de una entidad, como un hospital o farmacia,
 * que incluye información sobre salarios, bonificaciones y otros aspectos
 * relacionados con la remuneración.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */

public class Nomina {
    //Atributo
    private List<Empleado> empleados;
    //Constructor
    public Nomina(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    //Metodo
    public void generarNomina() {
        for (Empleado emp : empleados) {
            System.out.println(emp + ", Salario: " + emp.calcularSalario());
        }
    }
}

