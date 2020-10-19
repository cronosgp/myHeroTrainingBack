package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface
UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByEmail(String email);


    List<Usuario> findAllByEmail(String email);

    List<Usuario> findById(Long id);
}
