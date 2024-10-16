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
public class Paciente {
    String nombre;
    String cedula;
    int edad;
    String email;
    String telefono;

    public Paciente(String nombre, String cedula, int edad, String email, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + "," + cedula + "," + edad + "," + email + "," + telefono;
    }
}