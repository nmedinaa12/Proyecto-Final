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
    private String nombre;
    private String cedula;
    private int edad;
    private String carrera;

    public Gerente(String nombre, String cedula, int edad, String carrera) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Gerente: " + nombre + ", " + cedula + ", " + edad + ", " + carrera;
    }
}
