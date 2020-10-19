package com.ifsp.MyHeroTraining.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.Models.UsuarioFaseTempo;

public interface UsuarioFaseTempoRepository extends JpaRepository<UsuarioFaseTempo, Integer>{
	  List<UsuarioFaseTempo> findById(int id);
	
}
