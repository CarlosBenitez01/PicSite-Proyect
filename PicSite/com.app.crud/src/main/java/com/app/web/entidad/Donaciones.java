package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "donaciones")
public class Donaciones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_donacion")
	private Long id_donacion;
	
	@NotEmpty(message = "-Campo obligatorio. Ingrese un valor válido.")
	@Size(min = 3, max = 25, message = "-El nombre debe contener entre 5 y 15 caracteres")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "-El nombre no puede contener caracteres especiales")
	@Column(name = "nombres", nullable = false, length = 255)
	private String nombres;
	
	@NotEmpty(message = "-Campo obligatorio. Ingrese un valor válido.")
	@Size(min = 4, max = 25, message = "-El apellido debe contener entre 2 y 25 caracteres")
	@Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "-El apellido no puede contener caracteres especiales")
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@NotEmpty(message = "-Campo obligatorio. Ingrese un valor válido.")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "-El email debe ser una dirección válida que no contenga caracteres especiales adicionales a '@' y '.', ejemplo: picsite@gmail.com")
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@NotBlank(message = "Este campo es obligatorio. Seleccione una fecha")
	@Column(name = "fecha", nullable = false)
	private String fecha;

	@Column(name = "monto", nullable = false)
	private Double monto;
	
	@Column(name = "tipo_tarjeta", nullable = false)
	private String tipoTarjeta;
	
    @NotBlank(message = "El número de tarjeta es obligatorio")
    @Pattern(regexp = "^\\d{15,16}$", message = "El número de tarjeta debe tener 15 o 16 dígitos")
	@Column(name = "num_tarjeta", nullable = false)
	private String num_tarjeta;
	
    @NotBlank(message = "El CVV es obligatorio")
    @Size(min = 3, max = 4, message = "El CVV debe tener entre 3 y 4 dígitos")
    @Pattern(regexp = "^\\d+$", message = "El CVV debe contener solo dígitos")
	@Column(name = "cvv", nullable = false)
	private String cvv;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_donante_fk")
	public Usuario usuario;
	
	public Donaciones() {
		super();
	}

	public Donaciones(Long id_donacion, String nombres, String apellidos, String email, String fecha, Double monto,
			String tipoTarjeta, String num_tarjeta, String cvv, Usuario usuario) {
		super();
		this.id_donacion = id_donacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.fecha = fecha;
		this.monto = monto;
		this.tipoTarjeta = tipoTarjeta;
		this.num_tarjeta = num_tarjeta;
		this.cvv = cvv;
		this.usuario = usuario;
	}
	
	public Donaciones(String nombres, String apellidos, String email, String fecha, Double monto,
			String tipoTarjeta, String num_tarjeta, String cvv, Usuario usuario) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.fecha = fecha;
		this.monto = monto;
		this.tipoTarjeta = tipoTarjeta;
		this.num_tarjeta = num_tarjeta;
		this.cvv = cvv;
		this.usuario = usuario;
	}

	public Long getId_donacion() {
		return id_donacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getNum_tarjeta() {
		return num_tarjeta;
	}

	public void setNum_tarjeta(String num_tarjeta) {
		this.num_tarjeta = num_tarjeta;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Usuario getUsuario() {
		return usuario;
	}	
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
