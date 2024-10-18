/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 *Representa una condición médica o trastorno que afecta la salud de
 * los pacientes. Incluye detalles como el nombre de la enfermedad,
 * síntomas y posibles tratamientos.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */
public class Enfermedad {
    //Atributos
    private String nombre;
    private String sintomas;
   
    //Consctructor
    public Enfermedad(String nombre, String sintomas) {
        this.nombre = nombre;
        this.sintomas = sintomas;
    }
    //Metodos
    @Override
    public String toString() {
        return "Enfermedad: " + nombre + ", Síntomas: " + sintomas;
    }
}
