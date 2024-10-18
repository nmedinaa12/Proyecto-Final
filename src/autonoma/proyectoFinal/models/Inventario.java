/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectoFinal.models;

import java.util.HashMap;
import java.util.Map;


/**
 * Sistema o registro de los bienes disponibles, como medicamentos
 * y equipos, que son gestionados por la farmacia o el hospital 
 * para garantizar un suministro adecuado
 * @author Mariana Salgado & Nicolas Fernando Medina
 * @version 1.0.0
 * @since 2024-10-18
 * 
 */

public class Inventario {
    // Mapa que contiene los medicamentos y su cantidad disponible
    private Map<Medicamento, Integer> medicamentos = new HashMap<>();
    
    /**
     * Agrega un medicamento al inventario.
     *
     * @param medicamento El medicamento que se desea agregar.
     * @param cantidad La cantidad de unidades del medicamento.
     */
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
