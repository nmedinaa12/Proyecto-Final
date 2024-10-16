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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hospital {
    private String nombre;
    private String direccion;
    private String telefono;
    private String logo;
    private double presupuesto;
    private double ventaAnual;
    private Date fechaFundacion ;
    private boolean estadoFinanciero;
    private Gerente gerente;
    private Localizacion localizacion;
    private List<Empleado> empleados = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();

    public Hospital(String nombre, String direccion, String telefono, String logo, double presupuesto,
                    double ventaAnual, Date fechaFundacion, Gerente gerente, Localizacion localizacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.logo = logo;
        this.presupuesto = presupuesto;
        this.ventaAnual = ventaAnual;
        this.fechaFundacion = fechaFundacion;
        this.estadoFinanciero = true; // Por defecto, activo
        this.gerente = gerente;
        this.localizacion = localizacion;
    }

    public void registrarPatrocinio(double monto) {
        this.presupuesto += monto;
        if (this.presupuesto < 0) {
            this.estadoFinanciero = false; // Cambia a quiebra
            informarUsuario();
        }
    }

    public void actualizarEstado() {
        if (this.presupuesto < 0) {
            this.estadoFinanciero = false; // Cambia a quiebra
        }
    }

    public void informarUsuario() {
        System.out.println("El estado del hospital ha cambiado a: " + (estadoFinanciero ? "Activo" : "En quiebra"));
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void actualizarDatosHospital(String nombre, String direccion, String telefono, String logo,
                                         double presupuesto, Date fechaFundacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.logo = logo;
        this.presupuesto = presupuesto;
        this.fechaFundacion = fechaFundacion;
    }

    // Métodos para persistencia
    public void cargarDatos(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":", 2);
                if (partes.length < 2) {
                    System.err.println("La línea no contiene suficientes datos: " + linea);
                    continue; // Saltar esta línea
                }
                String clave = partes[0].trim();
                String valor = partes[1].trim();
                
                switch (clave) {
                    case "Hospital":
                        String[] hospitalDatos = valor.split(",");
                        this.nombre = hospitalDatos[0].trim();
                        this.direccion = hospitalDatos[1].trim();
                        this.telefono = hospitalDatos[2].trim();
                        this.logo = hospitalDatos[3].trim();
                        this.presupuesto = Double.parseDouble(hospitalDatos[4].trim());
                        this.ventaAnual = Double.parseDouble(hospitalDatos[5].trim());

                        // Cargar la fecha en formato YYYY-MM-DD
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        this.fechaFundacion = sdf.parse(hospitalDatos[6].trim());

                        // Asignar el estado como boolean
                        this.estadoFinanciero = hospitalDatos[7].trim().equalsIgnoreCase("Activo");
                        break;
                    case "Empleado":
                        // Procesar datos del empleado
                        break;
                    case "Paciente":
                        // Procesar datos del paciente
                        break;
                    default:
                        System.err.println("Tipo de dato desconocido: " + clave);
                }
            }
        } catch (IOException | NumberFormatException | ParseException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
    }

    public String guardarDatos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hospital: ").append(this.nombre).append(", ")
          .append(this.direccion).append(", ")
          .append(this.telefono).append(", ")
          .append(this.logo).append(", ")
          .append(this.presupuesto).append(", ")
          .append(this.ventaAnual).append(", ")
          .append(new SimpleDateFormat("yyyy-MM-dd").format(this.fechaFundacion)).append(", ")
          .append(this.estadoFinanciero ? "Activo" : "Inactivo");
        // Puedes agregar otros datos si es necesario
        return sb.toString();
    }
}
