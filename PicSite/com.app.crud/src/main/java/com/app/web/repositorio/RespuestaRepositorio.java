package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Respuestas;

@Repository
public interface RespuestaRepositorio extends JpaRepository<Respuestas, Long>{

}
