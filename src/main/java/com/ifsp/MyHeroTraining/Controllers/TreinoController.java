package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Forms.AtualizaUsuarioTreinoForms;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private FaseRepository faseRepository;

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
    public List<Fase> listaTreinos(@RequestParam(required = false) Integer id) {
        List<Fase> fase = faseRepository.findAll();
        return fase;

    }

    @PostMapping
    public Treino cadasTreinos(@RequestBody Treino treino) {
        // treinoRepository.save(treino);
        return treino;
    }

    /*  @PostMapping("/{id}")
       public Usuario UpdateUsuario(@PathVariable int id, @RequestBody AtualizaUsuarioTreinoForms atualizaUsuarioTreinoForms) {
           Usuario usuario = atualizaUsuarioTreinoForms.AtualizaId(id, treinoRepository, usuarioRepository);
           return usuario;
       }*/
    @GetMapping("/recupera")
    public List<Treino> buscaTreinosFeitos(@RequestParam int IdUsuario) {
        List<Treino> treino = treinoRepository.findByUsuariosId(IdUsuario);
        return treino;
    }

}
