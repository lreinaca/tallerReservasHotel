package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReservaService {
	
	private final ReservaRepository reservaRepository;
	@Autowired
	
	
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
		
		simulacionBaseDatos();
	}
	
	private void simulacionBaseDatos() {
		Reserva reserva1 = new Reserva("2023-01-01", "2023-01-02");
		Reserva reserva2 = new Reserva("2023-01-03", "2023-01-04");
		Reserva reserva3 = new Reserva("2023-01-05", "2023-01-06");
		
		save(reserva1);
		save(reserva2);
		save(reserva3);
	}
	
	public Reserva save(Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	public Reserva findById(String id) {
		return reservaRepository.findById(id);
	}
	
	public List<Reserva> findAll() {
		return reservaRepository.findAll();
	}
	
	public void deleteById(String id) {
		reservaRepository.deleteById(id);
	}
	
	public Reserva update(Reserva reserva) {
		return reservaRepository.update(reserva);
	}
	
	public List<Reserva> buscarPorFiltros(String idUsuario, String fechaIngreso, String fechaSalida) {
		return reservaRepository.buscarPorFiltros(idUsuario, fechaIngreso, fechaSalida);
	}
	
	
	

}
