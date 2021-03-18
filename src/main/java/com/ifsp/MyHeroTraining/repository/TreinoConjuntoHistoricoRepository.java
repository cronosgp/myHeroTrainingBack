package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Amizade;
import com.ifsp.MyHeroTraining.Models.TreinoConjunto;
import com.ifsp.MyHeroTraining.Models.TreinoConjuntoHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TreinoConjuntoHistoricoRepository extends JpaRepository<TreinoConjuntoHistorico, Integer> {

    Optional<TreinoConjunto> findByid(int id);

    List<TreinoConjunto> findByIdUsuario(int id);
    List<TreinoConjunto> findByIdConvidado(int id);

    @Query("SELECT u FROM TreinoConjuntoHistorico u where (u.idConvidado = ?1 OR u.idUsuario = ?1) AND u.data = ?2")
    Optional<TreinoConjuntoHistorico> findByContatoIdAndUsuarioId(int idConvidado, Date data);

    @Query("SELECT u FROM TreinoConjuntoHistorico u where u.idConvidado = ?1")
    List<TreinoConjuntoHistorico> findByConvidadoIdSolicitacoes(int id);

    @Query("SELECT u FROM TreinoConjuntoHistorico u where ((u.idConvidado = ?1 AND u.idUsuario = ?2) " +
            "OR (u.idConvidado = ?2 AND u.idUsuario = ?1)) AND u.data = ?3")
    List<TreinoConjuntoHistorico> findContatoAndUsuarioAndData(int id, int outro, Date data);
}
