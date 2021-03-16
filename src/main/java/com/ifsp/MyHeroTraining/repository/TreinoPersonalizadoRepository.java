package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.aquecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface TreinoPersonalizadoRepository extends JpaRepository<aquecimento, Integer> {


   @Transactional
    @Query(value ="SELECT * FROM aquecimento AS ex JOIN treino_personalizado_usuario as ps " +
            "ON PS.id_exercicio = ex.id " +
            "where ps.idusuario = :id AND ps.data_treino= :data",nativeQuery = true)
   List<aquecimento> findByIdusuario(@Param("id") int id, Date data);



}
