package com.ifsp.MyHeroTraining.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifsp.MyHeroTraining.Models.Caminhada;
import com.ifsp.MyHeroTraining.repository.CaminhadaRepository;

@RestController

@RequestMapping("/Caminhada")
public class CaminhadaController {
	@Autowired
	CaminhadaRepository caminhadaRepository;
	@PostMapping
	public ResponseEntity Salvar(@RequestBody Caminhada caminhada,@RequestHeader(value = "accept-language",required = true) String language) {
		try {
			Caminhada caminhadasalvar = caminhadaRepository.save(caminhada);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			
			
			 return ResponseEntity.badRequest().build();
		}
	}

	
	@GetMapping
	public ResponseEntity<List<Caminhada>> BuscarCaminhadas(@RequestParam int idUsuario,@RequestHeader(value = "accept-language",required = true) String language) {
		try {
		List<Caminhada> getCaminhada = caminhadaRepository.findByusuario(idUsuario);
		return ResponseEntity.ok(getCaminhada);
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().build();
		}
		
		
		
	}
}
