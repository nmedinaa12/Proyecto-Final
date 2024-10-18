/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 *
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 0.0.1
 * @since 2024-10-18
 * 
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
