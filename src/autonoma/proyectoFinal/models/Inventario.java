/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author user
 */

public class Inventario {
    private Map<Medicamento, Integer> medicamentos = new HashMap<>();

    public void agregarMedicamento(Medicamento medicamento, int cantidad) {
        medicamentos.put(medicamento, cantidad);
    }

    public void venderMedicamento(Medicamento medicamento, int cantidad) throws Exception {
        if (!medicamentos.containsKey(medicamento) || medicamentos.get(medicamento) < cantidad) {
            throw new Exception("Medicamento no disponible en el inventario.");
        }
        medicamentos.put(medicamento, medicamentos.get(medicamento) - cantidad);
    }
}
