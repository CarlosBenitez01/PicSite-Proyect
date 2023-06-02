package com.app.web.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.web.entidad.Donaciones;

@Service
public interface DonacionServicio {
	public List<Donaciones> listarRegistrosDeDonaciones();
	
	public Donaciones guardarRegistroDeDonacione(Donaciones donaciones);
	
	public Donaciones obtenerRegistroDeDonacionePorId(Long id);
}
