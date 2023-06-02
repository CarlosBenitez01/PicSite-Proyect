package com.app.web.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.web.entidad.Respuestas;

@Service
public interface RespuestaServicio {
	public List<Respuestas> listarRegistrosDeRespuestas();
	
	public Respuestas guardarRegistroDeRespuesta(Respuestas respuestas);
	
	public Respuestas obtenerRegistroDeRespuestaPorId(Long id);
}
