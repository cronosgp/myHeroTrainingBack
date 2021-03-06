package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.DadosTreino;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.Treino;

import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public interface FaseRepository extends JpaRepository<Fase, Integer> {

 // List<Treino> findByIdOrderById(Integer id);
    List<Fase> findFasesByTreinoId(Integer id);
    //List<Treino> findById(int id);
    List<Fase>findByUsuariosId(int id);
  List<Fase>findById(int id);
  @Transactional()
  @Query(value = "SELECT * from data_fase_usuario(:id);",nativeQuery = true)
  List<DadosTreino> carregaDados(int id);

}

