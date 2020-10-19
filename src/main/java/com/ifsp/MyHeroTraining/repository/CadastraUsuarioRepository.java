package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CadastraUsuarioRepository extends JpaRepository<CadastroUsuario, Integer> {
    Optional<CadastroUsuario> findByEmail(String email);
    List<CadastroUsuario> findByemail(String email);

  List<CadastroUsuario> findById(int id);



}
