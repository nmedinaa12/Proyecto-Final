/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Inventario {
    List<Medicamento> medicamentos;

    public Inventario() {
        medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public void venderMedicamento(String nombre) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.nombre.equals(nombre)) {
                System.out.println("Vendiendo medicamento: " + medicamento);
                return;
            }
        }
        System.out.println("Medicamento no encontrado: " + nombre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Medicamento medicamento : medicamentos) {
            sb.append(medicamento.toString()).append("\n");
        }
        return sb.toString();
    }
}