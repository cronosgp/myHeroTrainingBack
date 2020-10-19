package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.Exercicio;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.repository.ExercicioRepository;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/exercicio")
public class ExercicioController {
    @Autowired
    private ExercicioRepository exercicioRepository;
    @GetMapping
    public Page<Exercicio> listaExercicios(@RequestParam(required = false) Integer id, @RequestParam(required = false) Integer pagina, @RequestParam(required = false) Integer qnt) {
        if (pagina == null && qnt == null) {
            pagina = 0;
            qnt = 3;
            Pageable paginacao1 = PageRequest.of(pagina, qnt);
            Page<Exercicio> exercicios = exercicioRepository.findByTreinoId(id, paginacao1);
            return exercicios;
        } else {
            Pageable paginacao = PageRequest.of(pagina, qnt);
            Page<Exercicio> exercicios = exercicioRepository.findByTreinoId(id, paginacao);
            return exercicios;
        }
    }
}
