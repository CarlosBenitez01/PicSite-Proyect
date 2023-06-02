package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Imagenes;
import com.app.web.repositorio.ImagenRepositorio;

@Service
public class ImagenServicioImpl implements ImagenServicio{
	
	@Autowired
	private ImagenRepositorio repositorio;

	@Override
	public List<Imagenes> listarImagenes() {
		return repositorio.findAll();
		
	}

	@Override
	public Imagenes guardarImagen(Imagenes imagen) {
		return repositorio.save(imagen);
		
	}

	@Override
	public Imagenes obtenerImagenPorId(Long id) {
		return repositorio.findById(id).get();
	}
/*
	@Override
	public List<Imagenes> obtenerImagenesPorFkUsu(Long id) {
		return repositorio.findByUserIdFk(id);
	}
*/
}
