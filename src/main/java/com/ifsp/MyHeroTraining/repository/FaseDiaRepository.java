package com.ifsp.MyHeroTraining.repository;
import com.ifsp.MyHeroTraining.DTO.RetornoFaseDia;
import com.ifsp.MyHeroTraining.Models.FaseDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import java.util.List;
public interface FaseDiaRepository extends JpaRepository<FaseDia, Integer> {
    Optional<FaseDia> findByidfaseAndIdUsuario(int idusuario, int idFase);

  /*  @Transactional
    @Query(value = "select max(fase_dia.data_treino) from fase_Dia where fase_dia.id_usuario = :id ;", nativeQuery = true)
    Date findByIdUsuario(@Param("id") int id);*/

   /* @Transactional
    @Query(value = "select fase_Dia.id_fase from fase_Dia where fase_dia.id_usuario = :data ;", nativeQuery = true)
    Integer FindByDataTreino(@Param("data") Date data);*/
    @Transactional
    @Query(value = "select max(data_treino),idfase from fase_Dia  where id_usuario = :id " +
            "GROUP BY idfase ORDER BY MAX(data_treino) DESC LIMIT 1 ;", nativeQuery = true)
    RetornoFaseDia findByIdUsuario(@Param("id") int id);

}
