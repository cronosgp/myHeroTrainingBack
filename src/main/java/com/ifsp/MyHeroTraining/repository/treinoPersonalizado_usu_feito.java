package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.personalizado_usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface treinoPersonalizado_usu_feito extends JpaRepository<personalizado_usuario, Integer> {

    List<personalizado_usuario> findByusuarioAndData(int id,Date data );
}
