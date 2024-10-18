/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.Serializable;

/**
 *  Sustancia o combinación de sustancias utilizadas para prevenir, 
 * tratar o curar enfermedades. Los medicamentos pueden clasificarse en genéricos o de marca.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */
public abstract class Medicamento {
    //Atributos
    protected String nombre;
    protected double precio;
    
    //Constructor
    public Medicamento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public abstract void aplicarEfecto();
    //Metodos
    @Override
    public String toString() {
        return "Medicamento: " + nombre + ", Precio: " + precio;
    }
}


