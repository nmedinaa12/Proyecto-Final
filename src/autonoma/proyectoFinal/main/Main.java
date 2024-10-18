/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.main;

import autonoma.proyectoFinal.models.Empleado;
import autonoma.proyectoFinal.models.EmpleadoAreaSalud;
import autonoma.proyectoFinal.models.EmpleadoOperativo;
import autonoma.proyectoFinal.models.Farmacia;
import autonoma.proyectoFinal.models.Gerente;
import autonoma.proyectoFinal.models.Hospital;
import autonoma.proyectoFinal.models.Inventario;
import autonoma.proyectoFinal.models.Localizacion;
import autonoma.proyectoFinal.models.Medicamento;
import autonoma.proyectoFinal.models.MedicamentoGenerico;
import autonoma.proyectoFinal.models.MedicamentoMarca;
import autonoma.proyectoFinal.models.Paciente;
import autonoma.proyectoFinal.views.ActualizarDatosHospital;
import autonoma.proyectoFinal.views.VentanaPrincipal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * Clase principal para cargar datos y gestionar el hospital y sus empleados.
 * Esta clase incluye la carga de datos de un hospital, gerente y empleados desde archivos,
 * así como la adición de nuevos empleados al hospital.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 */

public class Main {
    public static void main(String[] args) {
        
        
        try {

         
            //Cargar Datos Hospital
            Hospital hospital = Hospital.cargarDatosHospital("hospital_datos.txt");

            //Datos Hospital
            
            // Aquí puedes probar los datos cargados del hospital
            System.out.println("Nombre del hospital: " + hospital.getNombre());
            System.out.println("Nombre del hospital: " + hospital.getFechaFundacion());

            // Cargar datos desde archivo
            hospital.cargarDatosHospital("hospital_datos.txt");
            System.out.println("cargar datos hospital");
            
            //Cargar Datos Hospital
            Gerente gerente = Gerente.cargarDatosGerente("hospital_datos.txt");

            // Aquí puedes probar los datos cargados del hospital
            System.out.println("Nombre del gerente: " + gerente.getNombre());

            // Cargar datos desde archivo
            gerente.cargarDatosGerente("hospital_datos.txt");
            System.out.println("cargar datos gerente");
            
            
            //EMPLEADOS
             // Agregar un empleado del área de salud
            Empleado nuevoEmpleadoSalud = new EmpleadoAreaSalud("Dr. Ana", "123456789", "40", 8000.0, "Pediatría", 40);
            System.out.println(nuevoEmpleadoSalud);
            hospital.agregarEmpleado(nuevoEmpleadoSalud);
            System.out.println("Empleado del área de salud agregado.");

            // Agregar un empleado operativo
            Empleado nuevoEmpleadoOperativo = new EmpleadoOperativo("Carlos Pérez", "987654321", "35", 5000.0, "Logística");
            System.out.println(nuevoEmpleadoOperativo);
            hospital.agregarEmpleado(nuevoEmpleadoOperativo);
            System.out.println("Empleado operativo agregado.");
            

//            // Modificar un empleado del área de salud (cambiando salario y especialidad)
//            Empleado empleadoModificadoSalud = new EmpleadoAreaSalud("Dr. Ana", "123456789", "40", 8500.0, "Neurología", 45);
//            boolean modificadoSalud = hospital.modificarEmpleado("123456789", empleadoModificadoSalud);
//            if (modificadoSalud) {
//                System.out.println("Empleado del área de salud modificado.");
//            } else {
//                System.out.println("Empleado no encontrado.");
//            }
//
//
//            // Modificar un empleado operativo (cambiando el área)
//            Empleado empleadoModificadoOperativo = new EmpleadoOperativo("Carlos Pérez", "987654321", "35", 5500.0, "Mantenimiento");
//            boolean modificadoOperativo = hospital.modificarEmpleado("987654321", empleadoModificadoOperativo);
//            if (modificadoOperativo) {
//                System.out.println("Empleado operativo modificado.");
//            } else {
//                System.out.println("Empleado no encontrado.");
//            }


        
            
//            new VentanaPrincipal(gerente,hospital).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
