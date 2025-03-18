package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	// Obtener todos los usuarios
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		List<Usuario> usuarios = usuarioService.findAll();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}

	// Obtener un usuario por ID
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable String id) {
		Usuario usuario = usuarioService.findById(id);
		if (usuario != null) {
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Crear un nuevo usuario
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		Usuario newUsuario = usuarioService.save(usuario);
		return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
	}

	// Actualizar un usuario existente
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
		Usuario existingUsuario = usuarioService.findById(id);
		if (existingUsuario != null) {
			usuario.setId(id);
			Usuario updatedUsuario = usuarioService.update(usuario);
			return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Eliminar un usuario
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
		Usuario existingUsuario = usuarioService.findById(id);
		if (existingUsuario != null) {
			usuarioService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Ruta con parámetros de consulta (query string)
	@GetMapping("/buscar")
	public ResponseEntity<List<Usuario>> buscarUsuarios(@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String email, @RequestParam(defaultValue = "0") int edad) {
		List<Usuario> usuarios = usuarioService.buscarPorFiltros(nombre, email, edad);
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}


	// Ruta que lee cabeceras HTTP
	@GetMapping("/auth")
	public ResponseEntity<Usuario> getUserByToken(@RequestHeader("Authorization") String authToken) {
		Usuario usuario = usuarioService.findByAuthToken(authToken);
		if (usuario != null) {
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	
}