package com.app.web.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.web.entidad.Filtros;

@Service
public interface FiltroServicio {
	public List<Filtros> listarRegistrosDeFiltros();
	
	public Filtros guardarRegistrosDeFiltros(Filtros filtros);
	
	public Filtros obtenerRegistroDeFiltrosPorId(Long id);
}
