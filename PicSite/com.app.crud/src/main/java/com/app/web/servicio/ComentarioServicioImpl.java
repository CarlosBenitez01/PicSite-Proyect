package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Comentarios;
import com.app.web.repositorio.ComentarioRepositorio;

@Service
public class ComentarioServicioImpl implements ComentarioServicio{
	
	@Autowired
	private ComentarioRepositorio repositorio;
	
	@Override
	public List<Comentarios> listarRegistrosDeComentarios() {
		return repositorio.findAll();
	}

	@Override
	public Comentarios guardarRegistroDeComentario(Comentarios comentarios) {
		return repositorio.save(comentarios);
	}

	@Override
	public Comentarios obtenerRegistroDeComentarioPorId(Long id) {
		return repositorio.findById(id).get();
	}

}
