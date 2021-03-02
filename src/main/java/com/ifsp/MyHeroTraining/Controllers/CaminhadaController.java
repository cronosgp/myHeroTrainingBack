package com.ifsp.MyHeroTraining.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.MyHeroTraining.Models.Caminhada;
import com.ifsp.MyHeroTraining.repository.CaminhadaRepository;

@RestController

@RequestMapping("/Caminhada")
public class CaminhadaController {
	@Autowired
	CaminhadaRepository caminhadaRepository;
	@PostMapping
	public ResponseEntity Salvar(@RequestBody Caminhada caminhada) {
		try {
			Caminhada caminhadasalvar = caminhadaRepository.save(caminhada);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			
			
			 return ResponseEntity.badRequest().build();
		}
	}

	
	@GetMapping
	public ResponseEntity<List<Caminhada>> BuscarCaminhadas(@RequestParam int idUsuario) {
		try {
		List<Caminhada> getCaminhada = caminhadaRepository.findByusuario(idUsuario);
		return ResponseEntity.ok(getCaminhada);
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().build();
		}
		
		
		
	}
}
