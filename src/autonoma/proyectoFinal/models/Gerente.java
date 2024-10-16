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
public class Gerente {
    String nombre;
    String cedula;

    public Gerente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return nombre + "," + cedula;
    }
}