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
public class Inventario implements Serializable {
    private List<Medicamento> listaMedicamentos;

    public Inventario() {
        this.listaMedicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento medicamento) {
        listaMedicamentos.add(medicamento);
    }

    public void venderMedicamento(String nombreMedicamento) {
        Medicamento medicamentoAVender = null;
        for (Medicamento medicamento : listaMedicamentos) {
            if (medicamento.getNombre().equalsIgnoreCase(nombreMedicamento)) {
                medicamentoAVender = medicamento;
                break;
            }
        }

        if (medicamentoAVender != null) {
            listaMedicamentos.remove(medicamentoAVender);
            System.out.println("Medicamento vendido: " + nombreMedicamento);
        } else {
            System.out.println("Medicamento no encontrado: " + nombreMedicamento);
        }
    }
}