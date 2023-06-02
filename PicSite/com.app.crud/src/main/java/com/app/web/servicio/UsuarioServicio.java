package com.app.web.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.web.entidad.Usuario;

@Service
public interface UsuarioServicio {
	public List<Usuario> listarUsuarios();
	
	public Usuario guardarUsuario(Usuario Usuario);
	
	public Usuario obtenerUsuarioPorId(Long id);
}
