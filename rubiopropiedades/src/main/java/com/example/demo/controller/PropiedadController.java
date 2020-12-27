package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.PropiedadDto;
import com.example.demo.models.Propiedad;
import com.example.demo.models.TipoPropiedades;
import com.example.demo.repository.PropiedadRepository;
import com.example.demo.repository.TipoPropiedadesRepository;;

@RestController
@RequestMapping("propiedad")
@CrossOrigin(origins="http://localhost:4200")
public class PropiedadController {

	@Autowired
	private PropiedadRepository propiedadRepository;
	
	@Autowired
	private TipoPropiedadesRepository tipoRepository;
	
	@GetMapping("/")
	public ResponseEntity mostrarTodos(){
		try{
			Iterable<Propiedad> lista = propiedadRepository.findAll();
			ArrayList<PropiedadDto> listaFinal = new ArrayList<PropiedadDto>();
			
			lista.forEach(element ->{
				PropiedadDto propiedad = new PropiedadDto(element);
				listaFinal.add(propiedad);
			});
			
			return ResponseEntity.ok(listaFinal);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity mostrarUno(@PathVariable int id){
		try{
			Optional<Propiedad> propiedadBuscada = propiedadRepository.findById(id);
			PropiedadDto propiedad;
			
			if(!propiedadBuscada.isPresent()){
				throw new Exception("No existe propiedad con ese Id.");
			}
			
			propiedad = new PropiedadDto(propiedadBuscada.get());
			
			return ResponseEntity.ok(propiedad);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity guardar(@RequestBody PropiedadDto propiedad){
		try{
			Propiedad propiedadAGuardar;
			Optional<TipoPropiedades> tipoOpcional = tipoRepository.findByNombre(propiedad.getTipoPropiedad());
			
			if(!tipoOpcional.isPresent()){
				throw new Exception("El tipo de propiedad indicado no existe.");
			}
			
			if(propiedad.getTitulo().isEmpty()){
				throw new Exception("El titulo no puede estar vacio.");
			}
			if(propiedad.getDescripcion().isEmpty()){
				throw new Exception("La descripcion no puede estar vacia.");
			}
			if(propiedad.getTipoOperacion().isEmpty()){
				throw new Exception("El tipo de operación no puede estar vacio.");
			}
			if(propiedad.getUnidadMonetaria().isEmpty()){
				throw new Exception("La unidad monetaria no puede estar vacia.");
			}
			if(propiedad.getValor()<0){
				throw new Exception("El valor no puede ser menor a 0.");
			}
			if(propiedad.getSupTotal()<0){
				throw new Exception("La superficie total no puede ser menor a 0.");
			}
			
			if(propiedad.check(propiedad.getSupCub())){
				throw new Exception("La superficie cubierta no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getSupSemi())){
				throw new Exception("La superficie semi-cubierta no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getSupDes())){
				throw new Exception("La superficie descubierta no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getAmbientes())){
				throw new Exception("La cantidad de ambientes no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getBanos())){
				throw new Exception("La cantidad de baños no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getToilettes())){
				throw new Exception("La cantidad de toilettes no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getAntiguedad())){
				throw new Exception("La antigüedad no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getPlantas())){
				throw new Exception("La cantidad de plantas no puede ser menor a 0.");
			}
			
			propiedadAGuardar = new Propiedad(propiedad, tipoOpcional.get());
			
			propiedadRepository.save(propiedadAGuardar);
			
			return ResponseEntity.ok("Se guardó correctamente.");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity modificar(@RequestBody PropiedadDto propiedad, @PathVariable int id){
		try{
			Propiedad propiedadAGuardar;
			Optional<TipoPropiedades> tipoOpcional = tipoRepository.findByNombre(propiedad.getTipoPropiedad());
			
			if(!propiedadRepository.findById(id).isPresent()){
				throw new Exception("La propiedad indicada no existe.");
			}
			if(!tipoOpcional.isPresent()){
				throw new Exception("El tipo de propiedad indicado no existe.");
			}
			
			if(propiedad.getTitulo().isEmpty()){
				throw new Exception("El titulo no puede estar vacio.");
			}
			if(propiedad.getDescripcion().isEmpty()){
				throw new Exception("La descripcion no puede estar vacia.");
			}
			if(propiedad.getTipoOperacion().isEmpty()){
				throw new Exception("El tipo de operación no puede estar vacio.");
			}
			if(propiedad.getUnidadMonetaria().isEmpty()){
				throw new Exception("La unidad monetaria no puede estar vacia.");
			}
			if(propiedad.getValor()<0){
				throw new Exception("El valor no puede ser menor a 0.");
			}
			if(propiedad.getSupTotal()<0){
				throw new Exception("La superficie total no puede ser menor a 0.");
			}
			
			if(propiedad.check(propiedad.getSupCub())){
				throw new Exception("La superficie cubierta no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getSupSemi())){
				throw new Exception("La superficie semi-cubierta no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getSupDes())){
				throw new Exception("La superficie descubierta no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getAmbientes())){
				throw new Exception("La cantidad de ambientes no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getBanos())){
				throw new Exception("La cantidad de baños no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getToilettes())){
				throw new Exception("La cantidad de toilettes no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getAntiguedad())){
				throw new Exception("La antigüedad no puede ser menor a 0.");
			}
			if(propiedad.check(propiedad.getPlantas())){
				throw new Exception("La cantidad de plantas no puede ser menor a 0.");
			}
			
			propiedad.setId(id);
			propiedadAGuardar = new Propiedad(propiedad, tipoOpcional.get());
			
			propiedadRepository.save(propiedadAGuardar);
			
			return ResponseEntity.ok("Se modificó correctamente.");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity borrar(@PathVariable int id){
		try{
			if(!propiedadRepository.findById(id).isPresent()){
				throw new Exception("No existe propiedad con ese Id.");
			}
			
			propiedadRepository.deleteById(id);
			
			return ResponseEntity.ok("Se eliminó correctamente.");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}
