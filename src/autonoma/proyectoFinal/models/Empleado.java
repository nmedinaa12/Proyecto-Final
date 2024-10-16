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
public abstract class Empleado implements Serializable {
    protected String nombre;
    protected String documentoIdentidad;
    protected int edad;
    protected double salarioBase;

    public Empleado(String nombre, String documentoIdentidad, int edad, double salarioBase) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.edad = edad;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return nombre + " (" + documentoIdentidad + "), Edad: " + edad + ", Salario Base: " + salarioBase;
    }
}
