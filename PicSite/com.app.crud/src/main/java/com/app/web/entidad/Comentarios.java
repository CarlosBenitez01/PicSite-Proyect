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
@Table(name = "comentarios")
public class Comentarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comentario")
	private Long id_comentario;
	
	@Column(name = "comentario", nullable = false, length = 255)
	private String comentario;
	
	@Column(name = "fecha", nullable = false)
	private String fecha;
	
	@Column(name = "numlikes", columnDefinition = "INTEGER")
	private int num_likes;
	
	@Column(name = "numdislikes", columnDefinition = "INTEGER")
	private int num_dislikes;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_comentario_fk")
	public Usuario usuario;
	
	public Comentarios() {
		super();
	}
	
	public Comentarios(String comentario, String fecha, Usuario usuario) {
		super();
		this.comentario = comentario;
		this.fecha = fecha;
		this.usuario = usuario;
	}

	public Comentarios(String comentario, String fecha, int num_likes, int num_dislikes,
			Usuario usuario) {
		super();
		this.comentario = comentario;
		this.fecha = fecha;
		this.num_likes = num_likes;
		this.num_dislikes = num_dislikes;
		this.usuario = usuario;
	}

	public Long getId_comentario() {
		return id_comentario;
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


	public int getNum_likes() {
		return num_likes;
	}


	public void setNum_likes(int num_likes) {
		this.num_likes = num_likes;
	}


	public int getNum_dislikes() {
		return num_dislikes;
	}


	public void setNum_dislikes(int num_dislikes) {
		this.num_dislikes = num_dislikes;
	}


	public Usuario getusuario() {
		return usuario;
	}


	public void setusuario(Usuario usuario) {
		this.usuario = usuario;
	}
}