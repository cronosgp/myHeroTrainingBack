package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.DTO.RetornoFaseDia;
import com.ifsp.MyHeroTraining.DTO.RetornoUsuarioTreino;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Treino_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

public interface TreinoUsuarioRepository extends JpaRepository<Treino_Usuario, Integer> {
    List<Treino_Usuario> findByfase(int id);
    List<Treino_Usuario> findByusuario(int id);

   // @Override
    Optional<Treino_Usuario> findByUsuarioAndFase(int idusuario, int idfase);

    Optional<Treino_Usuario> findByUsuario(int id);

    
    @Modifying
    @Transactional
    @Query(value = "delete from treino_usuario where usuario = :id ;", nativeQuery = true)
    void deleteById(@Param("id") int id);
    
    
}
