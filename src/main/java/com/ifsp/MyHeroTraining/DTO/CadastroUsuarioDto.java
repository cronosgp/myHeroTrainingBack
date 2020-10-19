package com.ifsp.MyHeroTraining.DTO;

import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.Models.EmailUsuario;

import javax.validation.constraints.Email;

public class CadastroUsuarioDto {

    public CadastroUsuarioDto(CadastroUsuario cadastroUsuario) {
        this.Id = cadastroUsuario.getId();
        this.nome = cadastroUsuario.getNome();
        this.email = cadastroUsuario.getEmail();
        this.senha = cadastroUsuario.getSenha();
    }
    public int getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
    private int Id;
    private String nome;
    private String email;
    private String senha;

}
