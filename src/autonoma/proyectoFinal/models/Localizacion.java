/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Localizacion {
    private double latitud;
    private double longitud;

    public Localizacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Localización: " + latitud + ", " + longitud;
    }
}



