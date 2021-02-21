package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.usuario_data_fase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usuarioDataFaseRepository extends JpaRepository<usuario_data_fase, Integer> {

    Optional<usuario_data_fase> findByIdUsuario(int id);


}
