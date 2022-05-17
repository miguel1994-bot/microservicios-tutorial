package com.usuario.service.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.servicio.UsuarioServicio;

@RestController
@RequestMapping("usuario")
public class UsuarioControlador extends  Usuario{
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario> usuarios = usuarioServicio.getAll();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build(); 
		}
		
		return ResponseEntity.ok(usuarios);
		
	} 
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id ){
		Usuario usuario = usuarioServicio.getUsuarioById(id);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		Usuario user = usuarioServicio.save(usuario);
		return ResponseEntity.ok(user);
	}
	
	/** Metodos usando el restTemplade para comunicar los micro servicios **/
	
	
	@GetMapping("carro/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarros(@PathVariable("usuarioId") int id){
		Usuario usuario = usuarioServicio.getUsuarioById(id);
		if(usuario == null ) {
			return ResponseEntity.notFound().build();
		}
		
		List<Carro> carros = usuarioServicio.getCarros(id);
		return ResponseEntity.ok(carros);
		
	}
	
	@GetMapping("moto/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") int id){
		Usuario usuario = usuarioServicio.getUsuarioById(id);
		if(usuario == null ) {
			return ResponseEntity.notFound().build();
		}
		
		List<Moto> motos = usuarioServicio.getMotos(id);
		return ResponseEntity.ok(motos);
		
	}
	
	/**Termina el uso del restTemplate**/
	
	
	
	/** Metodos Usando el feingClient para comunicar los microservicios **/
	@PostMapping("carro/{usuarioId}")
	public ResponseEntity<Carro> guardaCarro(@PathVariable ("usuarioId") int usuarioId, @RequestBody Carro carro){
		Carro nuevoCarro = usuarioServicio.saveCarro(usuarioId, carro);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@PostMapping("/moto/{usuarioId}")
	public ResponseEntity<Moto> guardaMoto(@PathVariable ("usuarioId") int usuarioId,  @RequestBody Moto moto){
		Moto nuevaMoto = usuarioServicio.saveMoto(usuarioId, moto);
		return ResponseEntity.ok(nuevaMoto); 
	}
	
	@GetMapping("todos/{usuarioId}")
	public ResponseEntity<Map<String, Object>> listarTodosVehiculos(@PathVariable("usuarioId") int usuarioId){
		Map<String, Object>  resultado  = usuarioServicio.getUsuarioVehiculos(usuarioId);
		return ResponseEntity.ok(resultado);
	}
	
	/** Finaliza el uso del feingClient **/
	
}
