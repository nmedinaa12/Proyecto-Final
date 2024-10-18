/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 * Medicamento desarrollado y comercializado bajo un nombre de marca 
 * específico. Suelen ser más caros debido a su desarrollo e investigación.
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */
public class MedicamentoMarca extends Medicamento {
    //Atributo
    private String marca;
    //Constructror
    public MedicamentoMarca(String nombre, double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }
    //Metodos
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
