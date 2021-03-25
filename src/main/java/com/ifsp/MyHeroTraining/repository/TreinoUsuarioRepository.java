package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Treino_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TreinoUsuarioRepository extends JpaRepository<Treino_Usuario, Integer> {

 List<Treino_Usuario> findByDataRealizadaAndUsuarioAndConjuntoIsNull(Date data, int id);

 @Query("SELECT u FROM Treino_Usuario u where u.dataRealizada = ?1 AND u.usuario = ?2 AND u.id_exercicio = ?3")
 List<Treino_Usuario> findByDataRealizadaAndUsuarioAndAndId_exercicio(Date data, int id, int id_exercicio);


 List<Treino_Usuario> findByDataRealizadaAndUsuarioAndConjuntoIsTrue(Date data, int id);


}
