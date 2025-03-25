package com.example.demo;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
public class Reserva {

	private String nombreUsuario;
	private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaSalida;
    //Constructor
	public Reserva() {
	       this.id = UUID.randomUUID().toString();
	   }

	public Reserva(String  nombreUsuario, LocalDate fechaIngreso, LocalDate fechaSalida) {
		this.id = UUID.randomUUID().toString();
		this.nombreUsuario = nombreUsuario;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	

	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public String getId() {
		return id;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
	

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}
