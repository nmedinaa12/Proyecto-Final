/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.Serializable;

/**
 * Información geográfica relacionada con la ubicación 
 * de entidades como hospitales, farmacias o el domicilio de los pacientes.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */
public class Localizacion {
    //Atributo
    private double latitud;
    private double longitud;
    
    //Constructor
    public Localizacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }
    //Metodos
    @Override
    public String toString() {
        return "Localización: " + latitud + ", " + longitud;
    }
}



