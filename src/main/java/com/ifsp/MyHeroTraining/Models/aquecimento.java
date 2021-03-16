package com.ifsp.MyHeroTraining.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class aquecimento {

    @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNomeExercicio(String nome) {
        this.nome = nome;
    }

    public String getCaminho_gif() {
        return caminho_gif;
    }

    public void setCaminho_gif(String caminho_gif) {
        this.caminho_gif = caminho_gif;
    }



    public int getQntd_pontos() {
        return qntd_pontos;
    }

    public void setQntd_pontos(int qntd_pontos) {
        this.qntd_pontos = qntd_pontos;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public String nome;
    public String caminho_gif;

    public String getParte_trablhada() {
        return parte_trablhada;
    }

    public void setParte_trablhada(String parte_trablhada) {
        this.parte_trablhada = parte_trablhada;
    }

    public String parte_trablhada;
    public int qntd_pontos;
    public int qntd;
    public int idFase;

    public int getId_tabela() {
        return id_tabela;
    }

    public void setId_tabela(int id_tabela) {
        this.id_tabela = id_tabela;
    }

    public int id_tabela;









}
