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
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nombre;
    private String cedula;
    private int edad;
    private String correoElectronico;
    private boolean estadoPaciente; // true: saludable, false: crítico
    private String telefono;
    private List<Enfermedad> enfermedades = new ArrayList<>();

    public Paciente(String nombre, String cedula, int edad, String correoElectronico, 
                    boolean estadoPaciente, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.estadoPaciente = estadoPaciente;
        this.telefono = telefono;
    }

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
