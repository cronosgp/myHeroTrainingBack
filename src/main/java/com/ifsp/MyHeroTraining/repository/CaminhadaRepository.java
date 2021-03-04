package com.ifsp.MyHeroTraining.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsp.MyHeroTraining.Models.Caminhada;

public interface CaminhadaRepository extends JpaRepository<Caminhada, Integer>{

	List<Caminhada> findByusuario(int usuario);
}
