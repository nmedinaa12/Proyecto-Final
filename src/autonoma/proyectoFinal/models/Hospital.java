/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombre;
    private String direccion;
    private String telefono;
    private String logo;
    private double presupuesto;
    private double ventaAnual;
    private LocalDate fechaFundacion ;
    private boolean estadoFinanciero;
    private Gerente gerente;
    private Localizacion localizacion;
    private List<Empleado> empleados = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();

    public Hospital(String nombre, String direccion, String telefono, String logo, double presupuesto,
                    double ventaAnual, LocalDate fechaFundacion, Gerente gerente, Localizacion localizacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.logo = logo;
        this.presupuesto = presupuesto;
        this.ventaAnual = ventaAnual;
        this.fechaFundacion = fechaFundacion;
        this.estadoFinanciero = true;
        this.gerente = gerente;
        this.localizacion = localizacion;
    }
    
    public Hospital() {
    }

    //get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getVentaAnual() {
        return ventaAnual;
    }

    public void setVentaAnual(double ventaAnual) {
        this.ventaAnual = ventaAnual;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public boolean isEstadoFinanciero() {
        return estadoFinanciero;
    }

    public void setEstadoFinanciero(boolean estadoFinanciero) {
        this.estadoFinanciero = estadoFinanciero;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
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

    public void actualizarDatosHospital(String nombre, String direccion, String telefono,
                                         double presupuesto, LocalDate fechaFundacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.presupuesto = presupuesto;
        this.fechaFundacion = fechaFundacion;
        
        guardarDatos("hospital_datos.txt");
    }
    
    // Métodos para persistencia
    public static Hospital cargarDatos(String rutaArchivo) {
        Hospital hospital = new Hospital();
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
                        hospital.nombre = hospitalDatos[0].trim();
                        hospital.direccion = hospitalDatos[1].trim();
                        hospital.telefono = hospitalDatos[2].trim();
                        hospital.logo = hospitalDatos[3].trim();
                        hospital.presupuesto = Double.parseDouble(hospitalDatos[4].trim());
                        hospital.ventaAnual = Double.parseDouble(hospitalDatos[5].trim());

                        // Cargar la fecha en formato YYYY-MM-DD
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        hospital.fechaFundacion = LocalDate.parse(hospitalDatos[6].trim(), formatter);

                        // Asignar el estado como boolean
                        hospital.estadoFinanciero = hospitalDatos[7].trim().equalsIgnoreCase("Activo");
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
        } catch (IOException | NumberFormatException | DateTimeParseException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
        return hospital;
    }

    public void guardarDatos(String filename) {
        List<String> lineas = new ArrayList<>();

        // Leer el archivo existente y reemplazar la línea del hospital
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Si la línea comienza con "Hospital:", la reemplazamos
                if (linea.startsWith("Hospital:")) {
                    String nuevaLinea = "Hospital: " + nombre + ", " + direccion + ", " + telefono + ", "
                            + logo + ", " + presupuesto + ", " + ventaAnual + ", " + fechaFundacion + ", "
                            + (estadoFinanciero ? "Activo" : "En quiebra");
                    lineas.add(nuevaLinea); // Agregamos la nueva línea
                } else {
                    lineas.add(linea); // Agregamos la línea sin cambios
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        // Escribir el contenido actualizado de vuelta en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String l : lineas) {
                writer.write(l);
                writer.newLine(); // Aseguramos que haya un salto de línea después de cada línea
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
