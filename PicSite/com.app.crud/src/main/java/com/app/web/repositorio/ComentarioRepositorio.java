package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Comentarios;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentarios, Long>{

}
