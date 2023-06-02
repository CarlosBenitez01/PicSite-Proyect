package com.app.web.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.web.entidad.Imagenes;

@Service
public interface ImagenServicio {
	public List<Imagenes> listarImagenes();
	
	public Imagenes guardarImagen(Imagenes imagen);
	
	public Imagenes obtenerImagenPorId(Long id);
	
	//public List<Imagenes> obtenerImagenesPorFkUsu(Long id);
}
