package com.ifsp.MyHeroTraining.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.Identity;

@Entity
public class Exercicios {
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

    public String getFotoDesmonstrativa() {
        return fotoDesmonstrativa;
    }

    public void setFotoDesmonstrativa(String fotoDesmonstrativa) {
        this.fotoDesmonstrativa = fotoDesmonstrativa;
    }

    public int getQuantidadeVezes() {
        return quantidadeVezes;
    }

    public void setQuantidadeVezes(int quantidadeVezes) {
        this.quantidadeVezes = quantidadeVezes;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String fotoDesmonstrativa;
    private  int quantidadeVezes;

}
