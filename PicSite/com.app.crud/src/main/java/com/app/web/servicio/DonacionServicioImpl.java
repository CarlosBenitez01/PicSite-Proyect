package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Donaciones;
import com.app.web.repositorio.DonacionesRepositorio;

@Service
public class DonacionServicioImpl implements DonacionServicio{

	@Autowired
	private DonacionesRepositorio repositorio;
	
	@Override
	public List<Donaciones> listarRegistrosDeDonaciones() {
		return repositorio.findAll();
	}

	@Override
	public Donaciones guardarRegistroDeDonacione(Donaciones donacion) {
		return repositorio.save(donacion);
	}

	@Override
	public Donaciones obtenerRegistroDeDonacionePorId(Long id) {
		return repositorio.findById(id).get();
	}

}
