package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.treinoPersonalizado_usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TreinoPersonalizadoUsuarioRepository extends JpaRepository<treinoPersonalizado_usuario,Integer> {




}
