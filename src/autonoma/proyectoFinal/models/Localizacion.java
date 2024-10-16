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
public class Localizacion implements Serializable {
    private String pais;
    private String ciudad;
    private String direccion;

    public Localizacion(String pais, String ciudad, String direccion) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Localización: " + direccion + ", " + ciudad + ", " + pais;
    }
}

