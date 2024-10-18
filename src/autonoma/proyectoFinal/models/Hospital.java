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
 * Institución médica dedicada a la atención
 * y tratamiento de pacientes. Ofrece diversos servicios 
 * médicos y cuenta con personal especializado.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hospital {
    //Atributos
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
    
    // Constructor
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

    //Metodos de acceso

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
    
    //Metodos
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
        
        guardarDatosHospital("hospital_datos.txt");
    }
    
    // Métodos para persistencia
    public static Hospital cargarDatosHospital(String rutaArchivo) {
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
                }
            }
        } catch (IOException | NumberFormatException | DateTimeParseException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
        return hospital;
    }

    public void guardarDatosHospital(String filename) {
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
    
    // Método para agregar un nuevo empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        guardarDatosEmpleado("hospital_datos.txt");
    }

    // Método para modificar un empleado por su número de cédula
    public boolean modificarEmpleado(String cedula, Empleado nuevoEmpleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCedula().equals(cedula)) {
                empleados.set(i, nuevoEmpleado);
                guardarDatosEmpleado("hospital_datos.txt");
                return true;
            }
        }
        return false;  // Si no se encontró el empleado con esa cédula
    }

    // Método para eliminar un empleado por su número de cédula
    public boolean eliminarEmpleado(String cedula) {
        Iterator<Empleado> it = empleados.iterator();
        while (it.hasNext()) {
            Empleado emp = it.next();
            if (emp.getCedula().equals(cedula)) {
                it.remove();
                guardarDatosEmpleado("hospital_datos.txt");
                return true;
            }
        }
        return false;  // Si no se encontró el empleado con esa cédula
    }

    // Guardar los empleados en el archivo de texto
    private void guardarDatosEmpleado(String link) {
        // Crear una lista para almacenar todas las líneas del archivo
        List<String> lineas = new ArrayList<>();

        // Leer el contenido existente del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(link))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Encontrar la posición de la línea que contiene "Paciente:"
        int indicePaciente = -1;
        for (int i = 0; i < lineas.size(); i++) {
            if (lineas.get(i).startsWith("Paciente:")) {
                indicePaciente = i;
                break;
            }
        }

        // Agregar los nuevos empleados antes de "Paciente:"
        for (Empleado emp : empleados) {
            String nuevaLinea;
            if (emp instanceof EmpleadoAreaSalud) {
                EmpleadoAreaSalud eSalud = (EmpleadoAreaSalud) emp;
                nuevaLinea = "Empleado: " + eSalud.getNombre() + ", " + eSalud.getCedula() + ", " +
                             eSalud.getEdad() + ", " + eSalud.getSalario() + ", " + eSalud.getEspecialidad() +
                             ", " + eSalud.getNumeroHorasTrabajadas();
            } else if (emp instanceof EmpleadoOperativo) {
                EmpleadoOperativo eOperativo = (EmpleadoOperativo) emp;
                nuevaLinea = "Empleado: " + eOperativo.getNombre() + ", " + eOperativo.getCedula() + ", " +
                             eOperativo.getEdad() + ", " + eOperativo.getSalario() + ", " + eOperativo.getArea();
            } else {
                continue; // Si no es un tipo reconocido, omitir
            }

            // Insertar la nueva línea en la posición correcta solo si no está ya en la lista
            if (!lineas.contains(nuevaLinea)) {
                lineas.add(indicePaciente, nuevaLinea);
                indicePaciente++; // Incrementar solo si se ha agregado una nueva línea
            }
        }

        // Escribir de nuevo todo el contenido en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(link))) {
            for (String l : lineas) {
                bw.write(l + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
