package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Treino_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreinoUsuarioRepository extends JpaRepository<Treino_Usuario, Integer> {
    List<Treino_Usuario> findByfase(int id);
    List<Treino_Usuario> findByusuario(int id);

}
