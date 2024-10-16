/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Hospital {
    String nombre;
    String nit;
    double presupuesto;
    double gastos;
    Localizacion localizacion;
    Gerente gerente;
    List<Empleado> empleados;
    List<Paciente> pacientes;
    Inventario inventario;

    public Hospital(String nombre, String nit, double presupuesto, double gastos, Localizacion localizacion, Gerente gerente) {
        this.nombre = nombre;
        this.nit = nit;
        this.presupuesto = presupuesto;
        this.gastos = gastos;
        this.localizacion = localizacion;
        this.gerente = gerente;
        this.empleados = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.inventario = new Inventario();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarMedicamento(Medicamento medicamento) {
        inventario.agregarMedicamento(medicamento);
    }

    public void mostrarEmpleados() {
        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    public void mostrarPacientes() {
        System.out.println("Lista de pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public void generarReporteSalarios() {
        System.out.println("Reporte de salarios:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.nombre + " - Salario: " + empleado.calcularSalario());
        }
    }

    public void guardarDatos(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Hospital\n");
            writer.write(nombre + "," + nit + "," + presupuesto + "," + gastos + "," + localizacion + "," + gerente + "\n");
            writer.write("Empleados\n");
            for (Empleado empleado : empleados) {
                writer.write(empleado + "\n");
            }
            writer.write("Pacientes\n");
            for (Paciente paciente : pacientes) {
                writer.write(paciente + "\n");
            }
            writer.write("Medicamentos\n");
            writer.write(inventario.toString());
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    public static Hospital cargarDatos(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (!line.equals("Hospital")) {
                return null; // Formato incorrecto
            }

            line = reader.readLine();
            String[] hospitalData = line.split(",");
            Localizacion localizacion = new Localizacion(hospitalData[4], hospitalData[5]);
            Gerente gerente = new Gerente(hospitalData[6], hospitalData[7]);

            Hospital hospital = new Hospital(hospitalData[0], hospitalData[1], Double.parseDouble(hospitalData[2]),
                    Double.parseDouble(hospitalData[3]), localizacion, gerente);

            line = reader.readLine(); // Empleados
            while (!(line = reader.readLine()).equals("Pacientes")) {
                String[] empleadoData = line.split(",");
                if (empleadoData.length == 6) {
                    hospital.agregarEmpleado(new EmpleadoSalud(empleadoData[0], empleadoData[1], Integer.parseInt(empleadoData[2]),
                            Double.parseDouble(empleadoData[3]), empleadoData[4], Integer.parseInt(empleadoData[5])));
                } else if (empleadoData.length == 5) {
                    hospital.agregarEmpleado(new EmpleadoOperativo(empleadoData[0], empleadoData[1], Integer.parseInt(empleadoData[2]),
                            Double.parseDouble(empleadoData[3]), empleadoData[4]));
                }
            }

            line = reader.readLine(); // Pacientes
            while (!(line = reader.readLine()).equals("Medicamentos")) {
                String[] pacienteData = line.split(",");
                hospital.registrarPaciente(new Paciente(pacienteData[0], pacienteData[1], Integer.parseInt(pacienteData[2]),
                        pacienteData[3], pacienteData[4]));
            }

            // Medicamentos
            String medicamentoLine;
            while ((medicamentoLine = reader.readLine()) != null) {
                String[] medicamentoData = medicamentoLine.split(",");
                if (medicamentoData.length == 3) {
                    hospital.agregarMedicamento(new MedicamentoGenerico(medicamentoData[0], medicamentoData[1], Double.parseDouble(medicamentoData[2])));
                } else if (medicamentoData.length == 4) {
                    hospital.agregarMedicamento(new MedicamentoDeMarca(medicamentoData[0], medicamentoData[1], Double.parseDouble(medicamentoData[2]), medicamentoData[3]));
                }
            }

            return hospital;
        } catch (IOException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "Hospital: " + nombre + ", NIT: " + nit + ", Presupuesto: " + presupuesto + ", Gastos: " + gastos;
    }
}
