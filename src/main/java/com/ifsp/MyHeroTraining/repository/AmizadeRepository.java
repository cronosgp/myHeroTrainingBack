package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Amizade;
import com.ifsp.MyHeroTraining.Models.dados_amizade;
import com.ifsp.MyHeroTraining.Models.dados_solic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface AmizadeRepository extends JpaRepository<Amizade, Integer> {
    Optional<Amizade> findByid(int id);
    List<Amizade> findByUsuarioId(int id);
    List<Amizade> findByAmizadeId(int id);

    @Query("SELECT u FROM Amizade u where (u.usuarioId = ?1 OR u.amizadeId = ?1) AND (u.usuarioId = ?2 OR u.amizadeId = ?2) ")
    List<Amizade> findAnyByUsuarioIdAndAmizadeId(int id, int id2);

    @Query("SELECT u FROM Amizade u where (u.usuarioId = ?1 OR u.amizadeId = ?1) AND u.status = true")
    List<Amizade> findAmizadeByUsuarioId(int id);

    @Query("SELECT u FROM Amizade u where u.amizadeId = ?1 AND u.status = false")
    List<Amizade> findByAmizadeIdSolicitacoes(int id);

    @Query("SELECT u FROM Amizade u where u.amizadeId = ?1 AND u.usuarioId = ?2")
    Optional<Amizade> findByAmizadeIdAndUsuarioId(int amizadeid, int usuarioid);

    @Transactional
    @Query(value = "SELECT * from amigo_carrega(:id);",nativeQuery = true)
   List<dados_amizade> amizade(int id);

    @Transactional
    @Query(value = "SELECT * from solic_carrega(:id);",nativeQuery = true)
    List<dados_solic> solicitacoes(int id);

}
