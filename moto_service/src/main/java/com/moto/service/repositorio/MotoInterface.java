package com.moto.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moto.service.entidades.Moto;

@Repository
public interface MotoInterface extends JpaRepository<Moto, Integer>{
	
	List<Moto> findByUsuarioId(int usuarioId);

}
