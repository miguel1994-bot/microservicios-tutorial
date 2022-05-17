package com.moto.service.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entidades.Moto;
import com.moto.service.service.MotoService;



@RestController
@RequestMapping("moto")
public class MotoControlador extends Moto{
	
	@Autowired
	private MotoService motoService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id) {
		Moto mot = motoService.getByIdMoto(id);
		return ResponseEntity.ok(mot);
	}
	
	@GetMapping
	public ResponseEntity<List<Moto>> listaMoto(){
		List<Moto> motos = motoService.getAll();
		if(motos == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motos);
	}
	
	@PostMapping
	public ResponseEntity<Moto> guardaMoto(@RequestBody Moto moto){
		Moto mot =  motoService.save(moto);
		return ResponseEntity.ok(mot);
	}
	
	@GetMapping("usuario/{usuarioId}")
	public ResponseEntity<List<Moto>>  motoUsuarioId(@PathVariable("usuarioId") int Id){
		List<Moto> motoUsuario = motoService.byUsuario(Id);
		if(motoUsuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(motoUsuario);
	}

}
