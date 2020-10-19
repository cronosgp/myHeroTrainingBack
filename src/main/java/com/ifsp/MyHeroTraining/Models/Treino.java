package com.ifsp.MyHeroTraining.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Treino {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Time horas;
    private String intensidade;
    private String nivel;

    @ManyToMany
    private List<Fase> fases = new ArrayList<>();
    public Treino() {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.intensidade = intensidade;
        this.nivel = nivel;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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

    public Time getHoras() {
        return horas;
    }

    public void setHoras(Time horas) {
        this.horas = horas;
    }

    public String getIntensidade() {
        return intensidade;
    }
    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

       public Boolean getTreinoFinalizado() {
        return treinoFinalizado;
    }

    public void setTreinoFinalizado(Boolean treinoFinalizado) {
        this.treinoFinalizado = treinoFinalizado;
    }

    public Boolean treinoFinalizado;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @ManyToOne
    private Usuario usuario;


    private String url;

    @ManyToMany
    private List<Usuario> usuarios;


    @OneToMany
    private List<Exercicio> exercicios;

}


