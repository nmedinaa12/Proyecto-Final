/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.Serializable;

/*
 * Un Empleado es una persona que pone a disposición sus habilidades, conocimientos
 * y esfuerzos para realizar un trabajo en beneficio de una empresa o empleador,
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 */
public abstract class Empleado {
    //Atributos 
    protected String nombre;
    protected String cedula;
    protected String edad;
    protected double salario;
    
    //Constructor
    public Empleado(String nombre, String cedula, String edad, double salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.salario = salario;
    }
    
    // Metodos de acceso

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    //Metodos

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", " + cedula + ", " + edad + ", " + salario;
    }

    public Empleado get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

