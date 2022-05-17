package com.carro.service.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro.service.entidades.Carro;
import com.carro.service.service.CarroService;

@RestController
@RequestMapping("carro")
public class CarroControlador extends Carro{
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id){
		Carro car = carroService.getByIdCarro(id);
		if(car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(car);
	}
	
	@GetMapping
	public ResponseEntity<List<Carro>> listaCarros(){
		List<Carro> car = carroService.getAll();
		return ResponseEntity.ok(car);
		
	}
	
	@GetMapping("usuario/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarrosUsuarioId(@PathVariable("usuarioId") int id){
		List<Carro> carUsuario = carroService.byUsuarioId(id);
		if(carUsuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carUsuario);
		
		
	}
	
	@PostMapping
	public ResponseEntity<Carro> guardaCarro(@RequestBody Carro carro){
		Carro car = carroService.save(carro);
		return ResponseEntity.ok(car);
		
	}
	
	

}
