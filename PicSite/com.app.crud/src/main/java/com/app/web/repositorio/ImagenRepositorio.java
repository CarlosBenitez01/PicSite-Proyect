package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Imagenes;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagenes, Long>{
	//@Query("SELECT * FROM imagenes i INNER JOIN usuarios u ON i.id_usuariofk = u.:id WHERE i.id_usuariofk = u.:id;")
    //List<Imagenes> findByUserIdFk(@Param("id") Long id);
	
}
