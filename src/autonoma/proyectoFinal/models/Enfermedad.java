/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 *
 * @author user
 */
public class Enfermedad {
    private String nombre;
    private String sintomas;

    public Enfermedad(String nombre, String sintomas) {
        this.nombre = nombre;
        this.sintomas = sintomas;
    }

    @Override
    public String toString() {
        return "Enfermedad: " + nombre + ", Síntomas: " + sintomas;
    }
}
