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
    String direccion;
    String ciudad;

    public Localizacion(String direccion, String ciudad) {
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return direccion + "," + ciudad;
    }
}


