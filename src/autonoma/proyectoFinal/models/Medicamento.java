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
public abstract class Medicamento implements Serializable {
    protected String nombre;
    protected String tipo;
    protected double precio;

    public Medicamento(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + "," + tipo + "," + precio;
    }
}

