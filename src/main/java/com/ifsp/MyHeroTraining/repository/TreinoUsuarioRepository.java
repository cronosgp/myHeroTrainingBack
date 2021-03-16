package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Treino_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface TreinoUsuarioRepository extends JpaRepository<Treino_Usuario, Integer> {

 List<Treino_Usuario> findByDataRealizadaAndUsuario(Date data, int id);
 @Transactional
 @Query(value ="SELECT * FROM treino_usuario where USUARIO = :id and id_exercicio in (25,26,27,28) AND data_realizada = :data",nativeQuery = true)
 List<Treino_Usuario> findByUsuario(@Param("id") int id, @Param("data") Date data);


}
