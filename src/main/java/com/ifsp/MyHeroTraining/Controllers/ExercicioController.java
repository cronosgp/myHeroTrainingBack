package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.Exercicio;
import com.ifsp.MyHeroTraining.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {
    @Autowired
    private ExercicioRepository exercicioRepository;
    @GetMapping
    public ResponseEntity<List<Exercicio>> listaExercicios(@RequestParam(required = false) int id,@RequestHeader(value = "accept-language",required = true) String language) {
        try {
          List<Exercicio> exercicios = exercicioRepository.findById(id);
            return ResponseEntity.ok(exercicios);
        }
        catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/atualiza")
    public ResponseEntity atualizaPontuação(@RequestParam  int id,@RequestHeader(value = "accept-language",required = true) String language){
       try {
      Boolean atualiza = exercicioRepository.atualizaPontos(id);

           return ResponseEntity.ok(atualiza);
       }
       catch (AuthenticationException e){
           return ResponseEntity.badRequest().build();
       }
    }

}

