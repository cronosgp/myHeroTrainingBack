package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.aquecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface aquecimentoRepository extends JpaRepository<aquecimento, Integer> {


   @Transactional
    @Query(value ="SELECT * FROM treino_personalizado AS ex JOIN treino_personalizado_usuario as ps " +
            "ON PS.id_exercicio = ex.id " +
            "where ps.idusuario = :id",nativeQuery = true)
   List<aquecimento> findByIdusuario(@Param("id") int id);

}
