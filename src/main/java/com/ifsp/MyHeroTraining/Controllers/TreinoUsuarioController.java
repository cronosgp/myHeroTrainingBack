package com.ifsp.MyHeroTraining.Controllers;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifsp.MyHeroTraining.DTO.RetornoUsuarioTreino;
import com.ifsp.MyHeroTraining.Models.Treino_Usuario;
import com.ifsp.MyHeroTraining.repository.TreinoUsuarioRepository;
@RestController
@RequestMapping("/treinousuario")
public class TreinoUsuarioController {
    @Autowired
    private TreinoUsuarioRepository treinoUsuarioRepository;
    @Transactional
    @PutMapping
    public Treino_Usuario UpdateUsuario(@RequestBody Treino_Usuario treino_usuario) {
        Optional<Treino_Usuario> usuarioFase = treinoUsuarioRepository.findByUsuarioAndFase(treino_usuario.getId_usuario(), treino_usuario.getId_fase());
        if (usuarioFase.isPresent()) {
            Treino_Usuario treino_usuario1 = usuarioFase.get();
            treino_usuario1.setId_fase(treino_usuario.getId_fase());
            treino_usuario1.setId_usuario(treino_usuario.getId_usuario());

            return treino_usuario1;
        } else {
            treinoUsuarioRepository.save(treino_usuario);
            return treino_usuario;
        }
    }
    @GetMapping("/recupera")
    public List<Treino_Usuario> recuperaFase(int id) {
        List<Treino_Usuario> fase = treinoUsuarioRepository.findByusuario(id);
        return fase;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
      
   treinoUsuarioRepository.deleteById(id);
    
  //  return usuarioTreino;
    
    }
  
}
