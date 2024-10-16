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
public class Gerente implements Serializable {
    private String nombre;
    private String documentoIdentidad;
    private int edad;
    private String departamento;

    public Gerente(String nombre, String documentoIdentidad, int edad, String departamento) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.edad = edad;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Gerente: " + nombre + " (" + documentoIdentidad + "), Edad: " + edad + ", Departamento: " + departamento;
    }
}