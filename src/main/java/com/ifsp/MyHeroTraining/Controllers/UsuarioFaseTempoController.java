package com.ifsp.MyHeroTraining.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.MyHeroTraining.Forms.UsuarioFaseTempoForms;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.UsuarioFaseTempo;
import com.ifsp.MyHeroTraining.repository.UsuarioFaseTempoRepository;

@RestController
@RequestMapping("/tempo")

public class UsuarioFaseTempoController {
	@Autowired
	UsuarioFaseTempoRepository usuarioFaseTempoRepository;

	@GetMapping
	public UsuarioFaseTempo listusers_tempo(@RequestParam Integer id_usuario, @RequestParam Integer id_fase) {

		List<UsuarioFaseTempo> listusers_tempo = null;
		UsuarioFaseTempo usuario_fase = null;
		int id = id_usuario;
		int id_f = id_fase;
		try {
		listusers_tempo = usuarioFaseTempoRepository.findAll();
			for (UsuarioFaseTempo user_tempo : listusers_tempo) {
				System.out.print(user_tempo.getId());
				if(user_tempo.getId_usuario() == id && user_tempo.getId_fase() == id_f) {
					usuario_fase = user_tempo;
				}
			}
		} catch (Exception e) {
System.out.println(e);
		}
		return usuario_fase;
	}

	@PostMapping

	public UsuarioFaseTempo insereTempo(@RequestBody UsuarioFaseTempoForms usuarioFaseTempoForms) {

		UsuarioFaseTempo usuarioFaseTempo = usuarioFaseTempoForms.converter();
		usuarioFaseTempoRepository.save(usuarioFaseTempo);

		return usuarioFaseTempo;

	}

}
