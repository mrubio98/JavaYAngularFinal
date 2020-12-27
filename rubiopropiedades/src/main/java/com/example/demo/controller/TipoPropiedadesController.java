package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.TipoPropiedadesDto;
import com.example.demo.models.TipoPropiedades;
import com.example.demo.repository.TipoPropiedadesRepository;

@RestController
@RequestMapping("tipo")
@CrossOrigin(origins="http://localhost:4200")
public class TipoPropiedadesController {
	
	@Autowired
	private TipoPropiedadesRepository tipoRepository;
	
	@GetMapping("/")
	public ResponseEntity traerTodos(){
		try{
			Iterable<TipoPropiedades> lista = tipoRepository.findAll();
			ArrayList<TipoPropiedadesDto> listaFinal = new ArrayList<TipoPropiedadesDto>();
			
			lista.forEach(element ->{
				TipoPropiedadesDto tipo = new TipoPropiedadesDto();
				
				tipo.setId(element.getId());
				tipo.setNombre(element.getNombre());
				
				listaFinal.add(tipo);
			});
			
			return ResponseEntity.ok(listaFinal);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity guardar(@RequestBody TipoPropiedadesDto tipoNuevo){
		try{
			TipoPropiedades tipoAGuardar = new TipoPropiedades();
			
			if(tipoNuevo.getNombre().isEmpty()){
				throw new Exception("El nombre no puede estar vacio.");
			}
			if(tipoNuevo.getNombre().length()>50){
				throw new Exception("La longitud del nombre no puede superar los 50 caracteres.");
			}
			if(tipoRepository.findByNombre(tipoNuevo.getNombre()).isPresent()){
				throw new Exception("Ya existe un tipo de propiedad con ese nombre.");
			}
			
			tipoAGuardar.setNombre(tipoNuevo.getNombre());
			tipoRepository.save(tipoAGuardar);
			
			return ResponseEntity.ok("Se guardó correctamente.");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity borrar(@PathVariable int id){
		try{
			if(!tipoRepository.findById(id).isPresent()){
				throw new Exception("No existe registro con ese id.");
			}
			tipoRepository.deleteById(id);
			return ResponseEntity.ok("Se eliminó correctamente.");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}
