package com.ifsp.MyHeroTraining.Controllers;
import com.ifsp.MyHeroTraining.Forms.AtualizaUsuarioTreinoForms;
import com.ifsp.MyHeroTraining.Models.*;
import com.ifsp.MyHeroTraining.repository.ExercicioRepository;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
@RestController
@RequestMapping("/treinos")
public class TreinoController {
    @Autowired
    private TreinoRepository treinoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ExercicioRepository exercicioRepository;

    /*@GetMapping
    public Page<Treino> listaTreinos(@RequestParam(required = false) Integer id, @RequestParam(required = false) int pagina, @RequestParam(required = false) int qnt) {
        Pageable paginacao = PageRequest.of(pagina, qnt);
        if (id == null) {
            Page<Treino> treino = treinoRepository.findAll(paginacao);
            return treino;
        } else {
            Page<Treino> treino = treinoRepository.findById(id, paginacao);
            return treino;
        }
    }*/
    @GetMapping
    public ResponseEntity <List<Exercicio>> listaTreinos(@RequestParam(required = false) Integer id) {
        try {
            List<Exercicio> treinoFase = exercicioRepository.findByTreinoIdOrderById(id);
            return ResponseEntity.ok(treinoFase);
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public Treino cadasTreinos(@RequestHeader(value = "accept-language",required = true) String language,@RequestBody Treino treino) {

        // treinoRepository.save(treino);

        return treino;
    }
    /*  @PostMapping("/{id}")
       public Usuario UpdateUsuario(@PathVariable int id, @RequestBody AtualizaUsuarioTreinoForms atualizaUsuarioTreinoForms) {
           Usuario usuario = atualizaUsuarioTreinoForms.AtualizaId(id, treinoRepository, usuarioRepository);
           return usuario;
       }*/
   
    @GetMapping("/idTreino")
    public List<Treino> idTreino(@RequestParam int id) {
        List<Treino> treino = treinoRepository.findByExerciciosId(id);
        return treino;
    }

}