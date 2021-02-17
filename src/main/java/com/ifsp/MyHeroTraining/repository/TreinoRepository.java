package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
public interface TreinoRepository extends JpaRepository<Treino, Integer> {
   Page<Treino> findById(Integer id, Pageable paginacao);

  //  List<Treino> findByUsuariosId(Integer idUsuario);

    List<Treino> findByFasesIdOrderById(int idfase);

    List<Treino> findById(int id);

    List<Treino> findByUsuariosId(int id);

    @Transactional()
    @Query(value = "SELECT * from carrega_desempenho(:id,:data_ini,:data_fim);",nativeQuery = true)
    List<desempenho> carregaDesempenho(int id, Date data_ini, Date data_fim);

 @Transactional()
 @Query(value = "SELECT * from  DADOS_USUARIO(:id);",nativeQuery = true)
 List<desempenho_dados> carregaDadosUsu(int id);




}