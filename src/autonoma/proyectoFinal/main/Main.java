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
        Localizacion localizacion = new Localizacion("Colombia", "Medellín", "Calle 123");
        Gerente gerente = new Gerente("Juan Pérez", "12345678", 45, "Administración");

        // Crear hospital
        Hospital hospital = new Hospital("Hospital San José St. Bonaventure", "Calle Falsa 123", "321654987", 1000000, 50000, "01/01/2000", localizacion, gerente);

        // Agregar empleados
        hospital.agregarEmpleado(new EmpleadoSalud("Diana Ruiz", "87654321", 30, 3000, "Médico", 160));
        hospital.agregarEmpleado(new EmpleadoOperativo("Pedro Gómez", "12312312", 28, 1500, "Limpieza"));

        // Registrar pacientes
        hospital.registrarPaciente(new Paciente("Ana Torres", "11223344", 25, "ana@example.com", "3001234567"));
        hospital.registrarPaciente(new Paciente("Luis Martínez", "22334455", 40, "luis@example.com", "3007654321"));

        // Agregar medicamentos
        hospital.agregarMedicamento(new MedicamentoGenerico("Paracetamol", "Analgésico", 5.00));
        hospital.agregarMedicamento(new MedicamentoDeMarca("Ibuprofeno", "Antiinflamatorio", 15.00, "Farmacéutica XYZ"));

        // Mostrar empleados y pacientes
        hospital.mostrarEmpleados();
        hospital.mostrarPacientes();

        // Generar reporte de salarios
        hospital.generarReporteSalarios();

        // Vender un medicamento
        hospital.venderMedicamento("Paracetamol");

        // Registrar un patrocinio
        hospital.registrarPatrocinio(10000);

        // Guardar datos del hospital
        hospital.guardarDatos("hospital.dat");

        // Cargar datos del hospital
        Hospital hospitalCargado = Hospital.cargarDatos("hospital.dat");
        if (hospitalCargado != null) {
            System.out.println("Hospital cargado exitosamente: " + hospitalCargado.nombre);
        }
    }
}