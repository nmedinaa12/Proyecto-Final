/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.Serializable;

/**
 * Persona que recibe tratamiento o servicios médicos en un hospital,
 * clínica o farmacia. Incluye datos personales, historial médico y tratamiento actual.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    //Atributo
    private String nombre;
    private String cedula;
    private int edad;
    private String correoElectronico;
    private boolean estadoPaciente; // true: saludable, false: crítico
    private String telefono;
    private List<Enfermedad> enfermedades = new ArrayList<>();
    
    //Constructor
    public Paciente(String nombre, String cedula, int edad, String correoElectronico, 
                    boolean estadoPaciente, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.estadoPaciente = estadoPaciente;
        this.telefono = telefono;
    }
    //Metodos
    public void curarEnfermedad(Medicamento medicamento, Enfermedad enfermedad) {
        if (enfermedades.contains(enfermedad)) {
            enfermedades.remove(enfermedad);
            // Agregar medicamento a la lista de medicinas recetadas
            // lógica de curación
        }
    }

    public void agregarEnfermedad(Enfermedad enfermedad) {
        enfermedades.add(enfermedad);
    }

    @Override
    public String toString() {
        return "Paciente: " + nombre + ", " + cedula + ", " + edad + ", " + correoElectronico + ", "
                + (estadoPaciente ? "Saludable" : "Crítico") + ", " + telefono;
    }
}
