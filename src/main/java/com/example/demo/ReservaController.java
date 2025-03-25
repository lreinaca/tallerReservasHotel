package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservas")

public class ReservaController {
	
	private final ReservaService reservaService;
	private final UsuarioService usuarioService;
	
	@Autowired
	public ReservaController(ReservaService reservaService, UsuarioService usuarioService) {
		this.reservaService = reservaService;
		this.usuarioService = usuarioService;
	}
	
	// buscar todas las reservas
	@GetMapping
	public ResponseEntity<List<Reserva>> getAllReservas() {
		List<Reserva> reservas = reservaService.findAll();
		return new ResponseEntity<>(reservas, HttpStatus.OK);
	}
	
	// crear una nueva reserva
	@PostMapping
	public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva, @RequestHeader("X-Client-Id") String idUsuario) {
		Usuario usuario = usuarioService.findById(idUsuario);
		if (usuario == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		reserva.setNombreUsuario(usuario.getNombre());
		Reserva newReserva = reservaService.save(reserva);
		return new ResponseEntity<>(newReserva, HttpStatus.CREATED);
	}
	
	// buscar reservas por filtros
	@GetMapping("/buscar")
	public ResponseEntity<List<Reserva>> buscarReservas(@RequestParam LocalDate fechaIngreso, @RequestParam LocalDate fechaSalida) {
		List<Reserva> reservas = reservaService.buscarPorFiltros(fechaIngreso, fechaSalida);
		return new ResponseEntity<>(reservas, HttpStatus.OK);
	}

}
