package com.ifsp.MyHeroTraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifsp.MyHeroTraining.Models.Pagamento;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    Pagamento findByusuario(int id);

    List<Pagamento>findByUsuario(int id);

}
