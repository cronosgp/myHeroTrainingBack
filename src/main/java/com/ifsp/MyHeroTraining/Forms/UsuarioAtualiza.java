package com.ifsp.MyHeroTraining.Forms;

import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;

import javax.validation.constraints.NotNull;

public class UsuarioAtualiza {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String token;

    public Usuario atualizar(@NotNull int id, @NotNull UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getOne(id);
        usuario.setToken(this.token);
        return usuario;
    }
}
