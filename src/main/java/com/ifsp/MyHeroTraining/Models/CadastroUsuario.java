package com.ifsp.MyHeroTraining.Models;
import javax.persistence.*;
import javax.persistence.Table;

@Entity

public class CadastroUsuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
   private String nome;
    private String senha;
    private String senhac;
    private String nascimento;
    private String peso;
    private String altura;
    private String contato;
    private String contato2;

    public CadastroUsuario() {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.senhac = senhac;
        this.nascimento = nascimento;
        this.peso = peso;
        this.altura = altura;
        this.contato = contato;
        this.contato2 = contato2;
    }

    public CadastroUsuario(String nome, String email, String senha, String senhac, String nascimento, String peso, String altura, String contato, String contato2) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.senhac = senhac;
        this.nascimento = nascimento;
        this.peso = peso;
        this.altura = altura;
        this.contato = contato;
        this.contato2 = contato2;
    }
    public CadastroUsuario(String email)
    {
        this.email = email;

    }

    public String getSenhac() {
        return senhac;
    }

    public void setSenhac(String senhac) {
        this.senhac = senhac;
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


    public int getId() {
        return id;
    }

    public void setId
            (int id) {
        this.id = id;
    }

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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}
