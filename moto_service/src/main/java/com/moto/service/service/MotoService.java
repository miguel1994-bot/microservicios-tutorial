package com.moto.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entidades.Moto;
import com.moto.service.repositorio.MotoInterface;

@Service
public class MotoService {

	@Autowired
	private MotoInterface motoInterface;
	
	
	public List<Moto> getAll(){
		return motoInterface.findAll();
	}
	
	public Moto getByIdMoto(int id) {
		return motoInterface.findById(id).orElse(null);
	}
	
	public List<Moto> byUsuario(int usuarioId){
		List<Moto> motoUsuario = motoInterface.findByUsuarioId(usuarioId);
		return motoUsuario;
	}
	
	public Moto save(Moto moto) {
		Moto mot = motoInterface.save(moto);
		return mot;
	}
}
