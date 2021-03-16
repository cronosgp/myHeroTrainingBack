package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Amizade;
import com.ifsp.MyHeroTraining.Models.TreinoConjunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TreinoConjuntoRepository extends JpaRepository<TreinoConjunto, Integer> {

    Optional<TreinoConjunto> findByid(int id);

    List<TreinoConjunto> findByIdUsuario(int id);


    List<TreinoConjunto> findByIdConvidado(int id);

    @Query("SELECT u FROM TreinoConjunto u where u.idConvidado = ?1 AND u.idUsuario = ?2")
    Optional<TreinoConjunto> findByContatoIdAndUsuarioId(int idConvidado, int idUsuario);

    @Query("SELECT u FROM TreinoConjunto u where u.idConvidado = ?1 AND u.status = false")
    List<TreinoConjunto> findByConvidadoIdSolicitacoes(int id);

    @Query("SELECT u FROM Amizade u where (u.usuarioId = ?1 OR u.amizadeId = ?1) AND u.status = true")
    List<TreinoConjunto> findContatoAndUsuarioIdTrue(int id);
}
