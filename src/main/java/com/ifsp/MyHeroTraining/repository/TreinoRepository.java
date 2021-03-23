package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.*;


import com.ifsp.MyHeroTraining.Models.Exercicio;

import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.Models.dadosClassificacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
public interface TreinoRepository extends JpaRepository<Treino, Integer> {
    Page<Treino> findById(Integer id, Pageable paginacao);

    //  List<Treino> findByUsuariosId(Integer idUsuario);


    List<Treino>findByExerciciosId(int id);

    List<Treino> findById(int id);

 


    @Transactional()

    @Query(value = "SELECT * from carrega_desempenho(:id,:data_ini,:data_fim, :filtro);",nativeQuery = true)
    List<desempenho> carregaDesempenho(int id, Date data_ini, Date data_fim, int filtro);

    @Transactional()
    @Query(value = "SELECT * from  DADOS_USUARIO(:id);",nativeQuery = true)
    List<desempenho_dados> carregaDadosUsu(int id);

    @Query(value = "SELECT * from ranking_usuario();",nativeQuery = true)
    List<dadosClassificacao> carregaDadosClassificao();






}