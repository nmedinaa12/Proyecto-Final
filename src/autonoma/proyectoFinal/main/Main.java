/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.main;

import autonoma.proyectoFinal.models.EmpleadoAreaSalud;
import autonoma.proyectoFinal.models.Farmacia;
import autonoma.proyectoFinal.models.Gerente;
import autonoma.proyectoFinal.models.Hospital;
import autonoma.proyectoFinal.models.Inventario;
import autonoma.proyectoFinal.models.Localizacion;
import autonoma.proyectoFinal.models.Medicamento;
import autonoma.proyectoFinal.models.MedicamentoGenerico;
import autonoma.proyectoFinal.models.MedicamentoMarca;
import autonoma.proyectoFinal.models.Paciente;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author user
 */


public class main {
    public static void main(String[] args) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaFundacion = LocalDate.parse("2000-01-01", formatter);



            Gerente gerente = new Gerente("Juan Pérez", "123456789", 45, "Medicina");
            Localizacion localizacion = new Localizacion(4.60971, -74.08175); // Bogotá
            Hospital hospital = new Hospital("Hospital San José St. Bonaventure", "Calle 123", "555-1234",
                    "logo.png", 1000000.0, 200000.0, fechaFundacion, gerente, localizacion);

            EmpleadoAreaSalud medico = new EmpleadoAreaSalud("Dr. Carlos", "987654321", 35, 5000.0, "Cardiología", 40);
            hospital.agregarEmpleado(medico);

            Paciente paciente = new Paciente("María López", "456789123", 30, "maria@example.com", true, "555-6789");
            hospital.agregarPaciente(paciente);

            // Agregar medicamentos
            Medicamento medicamento1 = new MedicamentoMarca("Paracetamol", 1000, "Marca A");
            Medicamento medicamento2 = new MedicamentoGenerico("Ibuprofeno", 800, "Ibuprofeno");
            Inventario inventario = new Inventario();
            Farmacia farmacia = new Farmacia(inventario);
            farmacia.agregarMedicamento(medicamento1);
            farmacia.agregarMedicamento(medicamento2);

            // Registrar patrocinio
            hospital.registrarPatrocinio(200000);

            System.out.println(hospital.getFechaFundacion());
            // Guardar datos archivo 
            hospital.guardarDatos("hospital_datos.txt");
            System.out.println("guardados");
         

            // Cargar datos desde archivo
            hospital.cargarDatos("hospital_datos.txt");
            System.out.println("cargar datos");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
