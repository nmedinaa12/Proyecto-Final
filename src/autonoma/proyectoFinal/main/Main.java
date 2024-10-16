/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.main;

import autonoma.proyectoFinal.models.EmpleadoOperativo;
import autonoma.proyectoFinal.models.EmpleadoSalud;
import autonoma.proyectoFinal.models.Gerente;
import autonoma.proyectoFinal.models.Hospital;
import autonoma.proyectoFinal.models.Localizacion;
import autonoma.proyectoFinal.models.MedicamentoDeMarca;
import autonoma.proyectoFinal.models.MedicamentoGenerico;
import autonoma.proyectoFinal.models.Paciente;

/**
 *
 * @author user
 */
public class main {
    public static void main(String[] args) {
        Localizacion localizacion = new Localizacion("Calle Falsa 123", "Ciudad Ficticia");
        Gerente gerente = new Gerente("Juan Pérez", "123456789");
        Hospital hospital = new Hospital("Hospital General", "NIT123", 1000000.0, 500000.0, localizacion, gerente);

        // Agregar empleados, pacientes y medicamentos
        hospital.agregarEmpleado(new EmpleadoSalud("Dr. Smith", "987654321", 45, 50.0, "Cardiología", 160));
        hospital.agregarEmpleado(new EmpleadoOperativo("Ana Gómez", "456789123", 30, 3000.0, "Asistente"));
        hospital.registrarPaciente(new Paciente("Carlos López", "321654987", 30, "carlos@example.com", "555-0123"));
        hospital.agregarMedicamento(new MedicamentoGenerico("Paracetamol", "Analgesico", 500.0));
        hospital.agregarMedicamento(new MedicamentoDeMarca("Ibuprofeno", "Anti-inflamatorio", 1000.0, "Marca X"));

        // Guardar datos
        hospital.guardarDatos("hospital_data.txt");

        // Cargar datos
        Hospital hospitalCargado = Hospital.cargarDatos("hospital_data.txt");
        if (hospitalCargado != null) {
            System.out.println("Datos cargados:");
            System.out.println(hospitalCargado);
            hospitalCargado.mostrarEmpleados();
            hospitalCargado.mostrarPacientes();
            hospitalCargado.generarReporteSalarios();
        } else {
            System.out.println("No se pudieron cargar los datos.");
        }
    }
}