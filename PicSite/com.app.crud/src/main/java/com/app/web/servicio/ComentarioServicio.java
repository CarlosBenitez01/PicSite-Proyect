package com.app.web.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.web.entidad.Comentarios;

@Service
public interface ComentarioServicio {

	public List<Comentarios> listarRegistrosDeComentarios();
	
	public Comentarios guardarRegistroDeComentario(Comentarios comentarios);
	
	public Comentarios obtenerRegistroDeComentarioPorId(Long id);
}
