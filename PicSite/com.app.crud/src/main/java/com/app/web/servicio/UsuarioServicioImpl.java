package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Usuario;
import com.app.web.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return repositorio.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		return repositorio.findById(id).get();
	}

	
	
}
