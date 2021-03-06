package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Amizade;
import com.ifsp.MyHeroTraining.Models.TreinoConjunto;
import com.ifsp.MyHeroTraining.Models.dados_solic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
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

    @Query("SELECT u FROM TreinoConjunto u where (u.idConvidado = ?1 OR u.idUsuario = ?1) AND u.status = true ")
    List<TreinoConjunto> findContatoAndUsuarioIdTrue(int id);

    @Query("SELECT u FROM TreinoConjunto u where (u.idConvidado = ?1 OR u.idUsuario = ?1) AND (u.idConvidado = ?2 OR u.idUsuario = ?2)")
    Optional<TreinoConjunto> findContatoAndUsuarioByOneId(int idConvidado, int idUsuario);

    @Query("SELECT u FROM TreinoConjunto u where (u.idConvidado = ?1 OR u.idUsuario = ?1) AND u.status = true AND u.aguardando = true")
    List<TreinoConjunto> findContatoAndUsuarioIdTrueAguardando(int id);


    @Query("SELECT u FROM TreinoConjunto u where (u.idConvidado = ?1 OR u.idUsuario = ?1) AND u.status = true " +
            "and u.data= ?2")
    List<TreinoConjunto> findContatoAndUsuarioIdTrue(int id, Date data);


    @Transactional
    @Query(value = "SELECT * from solic_treino(:id);",nativeQuery = true)
    List<dados_solic> solicitacoes(int id);



}
