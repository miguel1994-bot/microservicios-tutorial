package com.carro.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carro.service.entidades.Carro;
import com.carro.service.repositorio.CarroInterface;

@Service
public class CarroService {
	
	@Autowired
	public CarroInterface carroInterface;
	
	public List<Carro> getAll(){
		return carroInterface.findAll();
	}
	
	public Carro getByIdCarro(int id) {
		return carroInterface.findById(id).orElse(null);
		
	}
	
	public Carro  save(Carro carro) {
		Carro car = carroInterface.save(carro);
		return car;
	}
	
	public List<Carro> byUsuarioId(int usuarioId){
		return carroInterface.findByUsuarioId(usuarioId);
	}

}
