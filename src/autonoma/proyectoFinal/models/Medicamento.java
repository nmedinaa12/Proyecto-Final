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
public abstract class Medicamento {
    protected String nombre;
    protected double precio;

    public Medicamento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract void aplicarEfecto();

    @Override
    public String toString() {
        return "Medicamento: " + nombre + ", Precio: " + precio;
    }
}


