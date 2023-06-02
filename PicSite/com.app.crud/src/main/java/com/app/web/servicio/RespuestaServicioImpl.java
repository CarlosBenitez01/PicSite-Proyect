package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Respuestas;
import com.app.web.repositorio.RespuestaRepositorio;

@Service
public class RespuestaServicioImpl implements RespuestaServicio{
	
	@Autowired
	private RespuestaRepositorio repositorio;

	@Override
	public List<Respuestas> listarRegistrosDeRespuestas() {
		return repositorio.findAll();
	}

	@Override
	public Respuestas guardarRegistroDeRespuesta(Respuestas respuestas) {
		return repositorio.save(respuestas);
	}

	@Override
	public Respuestas obtenerRegistroDeRespuestaPorId(Long id) {
		return repositorio.findById(id).get();
	}

}
