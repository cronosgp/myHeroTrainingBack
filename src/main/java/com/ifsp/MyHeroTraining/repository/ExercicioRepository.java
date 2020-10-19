package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Exercicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercicioRepository extends JpaRepository<Exercicio,Integer> {
    Page<Exercicio> findByTreinoId(Integer id, Pageable paginacao);


    }
