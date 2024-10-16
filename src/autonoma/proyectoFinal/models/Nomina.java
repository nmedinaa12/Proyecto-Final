/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.util.List;

/**
 *
 * @author user
 */

public class Nomina {
    private List<Empleado> empleados;

    public Nomina(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void generarNomina() {
        for (Empleado emp : empleados) {
            System.out.println(emp + ", Salario: " + emp.calcularSalario());
        }
    }
}

