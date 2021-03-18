package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Exercicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ExercicioRepository extends JpaRepository<Exercicio,Integer> {
    Page<Exercicio> findByTreinoId(Integer id, Pageable paginacao);
    List<Exercicio> findByTreinoIdOrderById(Integer id);

    List<Exercicio> findById(int ind);

    @Query("SELECT u FROM Exercicio u where u.id = ?1")
    Optional<Exercicio> findOneById(int ind);


    @Transactional
    @Query(value = "SELECT  desempenho_usuario(:id);",nativeQuery = true)
   Boolean atualizaPontos(int id);


}
