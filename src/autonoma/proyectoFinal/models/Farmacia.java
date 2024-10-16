/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.List;

public class Farmacia {
    private List<Medicamento> medicamentosDisponibles = new ArrayList<>();
    private Inventario inventario;

    public Farmacia(Inventario inventario) {
        this.inventario = inventario;
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentosDisponibles.add(medicamento);
        // Agregar al inventario
        inventario.agregarMedicamento(medicamento, 10); // Agregar 10 por defecto
    }

    public void venderMedicamento(Medicamento medicamento, int cantidad) {
        try {
            inventario.venderMedicamento(medicamento, cantidad);
            System.out.println("Medicamento vendido: " + medicamento);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

