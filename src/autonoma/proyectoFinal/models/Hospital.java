/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class Hospital implements Serializable {
    private String nombre;
    private String direccion;
    private String telefono;
    private double presupuesto;
    private double gastosMensuales;
    private String fechaFundacion;
    private Localizacion localizacion;
    private Gerente gerente;
    private List<Empleado> empleados;
    private List<Paciente> pacientes;
    private Inventario inventario;

    public Hospital(String nombre, String direccion, String telefono, double presupuesto,
                    double gastosMensuales, String fechaFundacion, Localizacion localizacion, Gerente gerente) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.presupuesto = presupuesto;
        this.gastosMensuales = gastosMensuales;
        this.fechaFundacion = fechaFundacion;
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
        System.out.println("Empleados del Hospital:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    public void mostrarPacientes() {
        System.out.println("Pacientes del Hospital:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public void generarReporteSalarios() {
        System.out.println("Reporte de salarios del Hospital:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNombre() + ": " + empleado.calcularSalario());
        }
    }

    public void venderMedicamento(String nombreMedicamento) {
        inventario.venderMedicamento(nombreMedicamento);
    }

    public void registrarPatrocinio(double monto) {
        presupuesto += monto;
        System.out.println("Patrocinio registrado: " + monto);
    }

    public void guardarDatos(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(this);
            System.out.println("Datos guardados correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static Hospital cargarDatos(String nombreArchivo) throws ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (Hospital) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
            return null;
        }
    }
}