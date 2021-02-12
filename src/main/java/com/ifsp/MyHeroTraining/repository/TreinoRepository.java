package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.Models.dadosClassificacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface TreinoRepository extends JpaRepository<Treino, Integer> {
   Page<Treino> findById(Integer id, Pageable paginacao);

  //  List<Treino> findByUsuariosId(Integer idUsuario);

    List<Treino> findByFasesIdOrderById(int idfase);

    List<Treino> findById(int id);

    List<Treino> findByUsuariosId(int id);

    @Transactional()
    @Query(value = "SELECT * from ranking_usuario();",nativeQuery = true)
    List<dadosClassificacao> carregaDadosClassificao();





}