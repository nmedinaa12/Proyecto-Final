/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 *
 * @author user
 */
public class MedicamentoMarca extends Medicamento {
    private String marca;

    public MedicamentoMarca(String nombre, double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }

    @Override
    public void aplicarEfecto() {
        // Lógica para aplicar efecto del medicamento de marca
        System.out.println("Aplicando medicamento de marca: " + nombre);
    }

    @Override
    public String toString() {
        return super.toString() + ", Marca: " + marca;
    }
}
