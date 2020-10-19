package com.ifsp.MyHeroTraining.Forms;

import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;

import java.util.List;

public class AtualizaUsuarioTreinoForms {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;

    public Treino AtualizaId(int id, UsuarioRepository usuarioRepository, TreinoRepository treinoRepository) {
        Usuario usuario = usuarioRepository.getOne(id);
        String email = usuario.getEmail();
        List<Usuario>  usuarios = usuarioRepository.findAllByEmail(email);
        Treino treino = treinoRepository.getOne(this.id);
        treino.setUsuarios(usuarios);
        treinoRepository.save(treino);
        return treino;


    }

  /*  public Treino AtualizaIdTreino(int id, TreinoRepository treinoRepository, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getOne(id);
        String email = usuario.getEmail();
        List<Usuario>  usuarios = usuarioRepository.findAllByEmail(email);
        Treino treino = treinoRepository.getOne(this.id);
        treino.setUsuarios(usuarios);
        treinoRepository.save(treino);
        return treino;

    }*/
}
