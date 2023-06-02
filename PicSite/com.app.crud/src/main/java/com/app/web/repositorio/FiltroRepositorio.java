package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Filtros;

@Repository
public interface FiltroRepositorio extends JpaRepository<Filtros, Long>{

}
