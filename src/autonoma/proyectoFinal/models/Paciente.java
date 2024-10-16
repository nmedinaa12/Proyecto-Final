/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.Serializable;

/**
 *
 * @author nmedi
 */
public class Paciente implements Serializable {
    private String nombre;
    private String documentoIdentidad;
    private int edad;
    private String email;
    private String telefono;

    public Paciente(String nombre, String documentoIdentidad, int edad, String email, String telefono) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " (" + documentoIdentidad + "), Edad: " + edad + ", Email: " + email + ", Teléfono: " + telefono;
    }
}
