package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "respuestas")
public class Respuestas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_respuesta")
	private Long id_respuesta;
	
	@Column(name = "comentario", nullable = false, length = 255)
	private String comentario;
	
	@Column(name = "fecha", nullable = false)
	private String fecha;	
	
	@ManyToOne
	@JoinColumn(name = "id_comentario_fk")
	public Comentarios comentarioFk;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_respuesta_fk")
	public Usuario usuario;

	public Respuestas() {
		super();
	}
	
	public Respuestas(String comentario, String fecha, Comentarios comentarioFk,Usuario usuario) {
		super();
		this.comentario = comentario;
		this.fecha = fecha;
		this.comentarioFk = comentarioFk;
		this.usuario = usuario;
	}
	
	public Respuestas(Long id_respuesta, String comentario, String fecha, Comentarios comentarioFk ,Usuario usuario) {
		super();
		this.id_respuesta = id_respuesta;
		this.comentario = comentario;
		this.fecha = fecha;
		this.comentarioFk = comentarioFk;
		this.usuario = usuario;
	}

	public Long getId_respuesta() {
		return id_respuesta;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Comentarios getComentarioFk() {
		return comentarioFk;
	}

	public void setComentarioFk(Comentarios comentarioFk) {
		this.comentarioFk = comentarioFk;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
