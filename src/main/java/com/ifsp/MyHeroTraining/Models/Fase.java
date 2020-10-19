package com.ifsp.MyHeroTraining.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.cfg.context.Cascadable;
import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Fase {
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDificuldade() {
        return dificuldade;
    }
    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String dificuldade;

    public String getNome() {
        return nome;
    }

    public Time getHoras() {
        return horas;
    }

    public void setHoras(Time horas) {
        this.horas = horas;
    }

    private Time horas;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    private String nome;
    private String nivel;

    public String getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }

    private String intensidade;

    public List<Treino> getTreino() {
        return treino;
    }
    public void setTreino(List<Treino> treino) {
        this.treino = treino;
    }
    @ManyToMany
    private List<Treino> treino;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @OneToMany

    private List<Usuario>usuarios = new ArrayList<>();

  
}