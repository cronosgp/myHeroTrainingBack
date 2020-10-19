package com.ifsp.MyHeroTraining.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
public class Exercicio {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminho_gif() {
        return caminho_gif;
    }

    public void setCaminho_gif(String caminho_gif) {
        this.caminho_gif = caminho_gif;
    }

    public String getParteTrablhada() {
        return parteTrablhada;
    }

    public void setParteTrablhada(String parteTrablhada) {
        this.parteTrablhada = parteTrablhada;
    }

    public int getQntd_pontos() {
        return qntd_pontos;
    }

    public void setQntd_pontos(int qntd_pontos) {
        this.qntd_pontos = qntd_pontos;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

   // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private String caminho_gif;
    private String parteTrablhada;
    private int qntd_pontos;
    private String dificuldade;

    public String getQntd() {
        return qntd;
    }

    public void setQntd(String qntd) {
        this.qntd = qntd;
    }

    private String qntd;

    @ManyToMany
    private List<Treino> treino;
}
