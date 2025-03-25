package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReservaService {

	private final ReservaRepository reservaRepository;
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Autowired

	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;

		simulacionBaseDatos();
	}

	private void simulacionBaseDatos() {
		Reserva reserva1 = new Reserva("Juan", LocalDate.parse("2025-03-20", FORMATTER),
				LocalDate.parse("2025-03-24", FORMATTER));
		Reserva reserva2 = new Reserva("Pedro", LocalDate.parse("2025-03-25", FORMATTER),
				LocalDate.parse("2025-03-30", FORMATTER));
		Reserva reserva3 = new Reserva("Maria", LocalDate.parse("2025-05-20", FORMATTER),
				LocalDate.parse("2025-05-24", FORMATTER));
		Reserva reserva4 = new Reserva("Jose", LocalDate.parse("2025-04-25", FORMATTER),
				LocalDate.parse("2025-05-30", FORMATTER));
		Reserva reserva5 = new Reserva("Ana", LocalDate.parse("2025-03-20", FORMATTER),
				LocalDate.parse("2025-03-24", FORMATTER));
		Reserva reserva6 = new Reserva("Luis", LocalDate.parse("2025-03-25", FORMATTER),
				LocalDate.parse("2025-03-30", FORMATTER));
		Reserva reserva7 = new Reserva("Carlos", LocalDate.parse("2025-03-20", FORMATTER),
				LocalDate.parse("2025-03-24", FORMATTER));
		
			

		save(reserva1);
		save(reserva2);
		save(reserva3);
		save(reserva4);
		save(reserva5);
		save(reserva6);
		save(reserva7);

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

	public List<Reserva> buscarPorFiltros(LocalDate fechaIngreso, LocalDate fechaSalida) {
		return reservaRepository.buscarPorFiltros(fechaIngreso, fechaSalida);

	}

}
