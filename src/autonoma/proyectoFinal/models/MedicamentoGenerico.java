/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 *
 * @author user
 */
public class MedicamentoGenerico extends Medicamento {
    private String sustanciaActiva;

    public MedicamentoGenerico(String nombre, double precio, String sustanciaActiva) {
        super(nombre, precio);
        this.sustanciaActiva = sustanciaActiva;
    }

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

