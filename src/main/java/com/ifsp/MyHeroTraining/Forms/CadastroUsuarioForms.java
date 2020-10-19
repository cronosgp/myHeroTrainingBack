package com.ifsp.MyHeroTraining.Forms;

import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.Models.EmailUsuario;
import com.ifsp.MyHeroTraining.Models.Usuario;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CadastroUsuarioForms {
    @NotNull @NotEmpty
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    private String senhac;
    private String nascimento;
    private String peso;
    private String altura;
    private String contato;
    private String contato2;


     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhac() {
        return senhac;
    }

    public void setSenhac(String senhac) {
        this.senhac = senhac;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }

    public CadastroUsuario converter(){
        return new CadastroUsuario( nome, email,  senha, senhac, nascimento, peso, altura,contato, contato2);
    }


}