package com.example.demo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class ReservaRepository {
	 // Simulamos una base de datos con un Map
    private final Map<String, Reserva> baseDeDatos = new HashMap<>();

    // Guardar una Reserva 
    public Reserva save(Reserva reserva) {
        baseDeDatos.put(reserva.getId(), reserva);
        return reserva;
    }
    
    // Encontrar una reserva por ID
    public Reserva findById(String id) {
        return baseDeDatos.get(id);
    }
    
    // Listar todos las reservas
    public List<Reserva> findAll() {
        return new ArrayList<>(baseDeDatos.values());
    }
    
    // Eliminar una reserva
    public void deleteById(String id) {
        baseDeDatos.remove(id);
    }
    
    // Actualizar una reserva
    public Reserva update(Reserva reserva) {
        if (baseDeDatos.containsKey(reserva.getId())) {
            baseDeDatos.put(reserva.getId(), reserva);
            return reserva;
        }
        return null;
    }
    
    // Buscar reservas por filtros
    public List<Reserva> buscarPorFiltros( LocalDate fechaIngreso, LocalDate fechaSalida) {
        
    	return baseDeDatos.values().stream()
                .filter(reserva -> fechaIngreso == null || !reserva.getFechaIngreso().isBefore(fechaIngreso)) // fechaIngreso ≤ reserva.getFechaIngreso()
                .filter(reserva -> fechaSalida == null || !reserva.getFechaIngreso().isAfter(fechaSalida))  // reserva.getFechaIngreso() ≤ fechaSalida
                .collect(Collectors.toList());
    }
}
