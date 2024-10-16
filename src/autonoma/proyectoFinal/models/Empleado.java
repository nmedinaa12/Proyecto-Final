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
    protected String nombre;
    protected String cedula;
    protected int edad;
    protected double salario;

    public Empleado(String nombre, String cedula, int edad, double salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.salario = salario;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", " + cedula + ", " + edad + ", " + salario;
    }
}

