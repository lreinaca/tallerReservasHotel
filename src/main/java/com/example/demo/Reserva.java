package com.example.demo;
import java.util.UUID;
public class Reserva {

	private Usuario usuario;
	private String id;
	private String fechaIngreso;
	private String fechaSalida;
    //Constructor
	public Reserva() {
	       this.id = UUID.randomUUID().toString();
	   }

	public Reserva(Usuario usuario, String fechaIngreso, String fechaSalida) {
		this.usuario = usuario;
		this.id = UUID.randomUUID().toString();
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getId() {
		return id;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Override
	public String toString() {
		return "Reserva{" +
				"usuario=" + usuario +
				", id='" + id + '\'' +
				", fechaIngreso='" + fechaIngreso + '\'' +
				", fechaSalida='" + fechaSalida + '\'' +
				'}';
	}
}
