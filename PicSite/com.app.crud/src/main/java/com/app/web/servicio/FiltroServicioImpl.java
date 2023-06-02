package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Filtros;
import com.app.web.repositorio.FiltroRepositorio;

@Service
public class FiltroServicioImpl implements FiltroServicio{
	
	@Autowired
	private FiltroRepositorio repositorio;

	@Override
	public List<Filtros> listarRegistrosDeFiltros() {
		return repositorio.findAll();
	}

	@Override
	public Filtros guardarRegistrosDeFiltros(Filtros filtros) {
		return repositorio.save(filtros);
	}

	@Override
	public Filtros obtenerRegistroDeFiltrosPorId(Long id) {
		return repositorio.findById(id).get();
	}
	
	
}
