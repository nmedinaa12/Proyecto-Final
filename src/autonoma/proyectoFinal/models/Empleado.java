/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.Serializable;

/**
 *
 * @author user
 */
public abstract class Empleado {
    String nombre;
    String cedula;
    int edad;
    double salario;

    public Empleado(String nombre, String cedula, int edad, double salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.salario = salario;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return nombre + "," + cedula + "," + edad + "," + salario;
    }
}
