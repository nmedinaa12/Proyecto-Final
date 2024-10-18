/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.Serializable;

/*
 * Un trabajador es una persona que pone a disposición sus habilidades, conocimientos
 * y esfuerzos para realizar un trabajo en beneficio de una empresa o empleador,
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 0.0.1
 * @since 2024-10-18
 */
public abstract class Empleado {
    //Atributos 
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
    
    //Metodos

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", " + cedula + ", " + edad + ", " + salario;
    }
}

