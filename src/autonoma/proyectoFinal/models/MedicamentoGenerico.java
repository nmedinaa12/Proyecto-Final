/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 * Medicamento equivalente a uno de marca en términos de principios activos,
 * dosis y efectos terapéuticos, pero generalmente a menor costo.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */
public class MedicamentoGenerico extends Medicamento {
    //Atributo
    private String sustanciaActiva;
    
    //Constructor
    public MedicamentoGenerico(String nombre, double precio, String sustanciaActiva) {
        super(nombre, precio);
        this.sustanciaActiva = sustanciaActiva;
    }
    //Metodos
    @Override
    public void aplicarEfecto() {
        // Lógica para aplicar efecto del medicamento genérico
        System.out.println("Aplicando medicamento genérico: " + nombre);
    }

    @Override
    public String toString() {
        return super.toString() + ", Sustancia Activa: " + sustanciaActiva;
    }
}

