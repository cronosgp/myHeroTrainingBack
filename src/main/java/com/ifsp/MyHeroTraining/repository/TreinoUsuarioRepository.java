package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Treino_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TreinoUsuarioRepository extends JpaRepository<Treino_Usuario, Integer> {
      List<Treino_Usuario> findByDataRealizadaAndUsuario(Date data, int id);

}
