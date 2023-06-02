package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotEmpty(message = "-Campo obligatorio. Ingrese un valor válido.")
	@Size(min = 5, max = 15, message = "-El nombre debe contener entre 5 y 15 caracteres")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "-El nombre no puede contener caracteres especiales")
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@NotEmpty(message = "-Campo obligatorio. Ingrese un valor válido.")
	@Size(min = 4, max = 20 , message = "-El email debe contener entre 4 y 20 caracteres")
	@Column(name = "email", nullable = false, length = 150, unique=true)
	private String email;
	
	@NotEmpty(message = "-Campo obligatorio. Ingrese un valor válido.")
	@Size(min = 5, max = 15, message = "-La contraseña debe contener entre 5 y 15 caractéres")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "-La contraseña no puede contener caracteres especiales")
	@Column(name = "password", nullable = false, length = 150)
	private String password;
	
	@Column(name = "foto", nullable = false, length = 300)
	private String foto;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombre, String email, String password, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.foto = foto;
	}

	public Usuario(String nombre, String email, String password, String foto) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.foto = foto;
	}



	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


}
