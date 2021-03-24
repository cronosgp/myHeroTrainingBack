package com.ifsp.MyHeroTraining.repository;

import com.ifsp.MyHeroTraining.Models.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {
    List<Notificacao> findByIdUsuario(int id);
    Optional<Notificacao> findById (int id);
}
