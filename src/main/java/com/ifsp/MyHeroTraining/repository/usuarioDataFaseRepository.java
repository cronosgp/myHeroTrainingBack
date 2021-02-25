package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.DadosTreino;
import com.ifsp.MyHeroTraining.Models.aquecimento;
import com.ifsp.MyHeroTraining.Models.usuario_data_fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface usuarioDataFaseRepository extends JpaRepository<usuario_data_fase, Integer> {

    Optional<usuario_data_fase> findByIdUsuario(int id);
    @Transactional
    @Query(value = "SELECT TREINO_ID from exercicio_treino " +
            "WHERE EXERCICIO_ID = :id",nativeQuery = true )
   Integer fase (@Param("id") int id);


}
