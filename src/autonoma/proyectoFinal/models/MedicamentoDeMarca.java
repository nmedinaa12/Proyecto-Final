/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 *
 * @author user
 */
public class MedicamentoDeMarca extends Medicamento {
    String fabricante;

    public MedicamentoDeMarca(String nombre, String tipo, double precio, String fabricante) {
        super(nombre, tipo, precio);
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return super.toString() + "," + fabricante;
    }
}