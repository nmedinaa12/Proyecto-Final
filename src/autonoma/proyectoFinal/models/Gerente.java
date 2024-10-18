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
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Gerente {
    private String nombre;
    private String cedula;
    private String edad;
    private String carrera;

    public Gerente(String nombre, String cedula, String edad, String carrera) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.carrera = carrera;
    }
    
    public Gerente() {

    }
    
    // get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public void actualizarDatosGerente(String nombre, String cedula, String edad,
                                         String carrera) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.carrera = carrera;

        
        guardarDatosGerente("hospital_datos.txt");
    }
    
    public static Gerente cargarDatosGerente(String rutaArchivo) {
        Gerente gerente = new Gerente();
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
                    case "Gerente":
                        String[] gerenteDatos = valor.split(",");
                        gerente.nombre = gerenteDatos[0].trim();
                        gerente.cedula = gerenteDatos[1].trim();
                        gerente.edad = gerenteDatos[2].trim();
                        gerente.carrera = gerenteDatos[3].trim();

                        break;
                }
            }
        } catch (IOException | NumberFormatException | DateTimeParseException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
        }
        return gerente;
    }

    public void guardarDatosGerente(String filename) {
        List<String> lineas = new ArrayList<>();

        // Leer el archivo existente y reemplazar la línea del hospital
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Si la línea comienza con "Hospital:", la reemplazamos
                if (linea.startsWith("Gerente:")) {
                    String nuevaLinea = "Gerente: " + nombre + ", " + cedula + ", " + edad + ", " + carrera;
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
