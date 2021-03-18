package com.ifsp.MyHeroTraining.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Date;

@Entity
public class TreinoConjuntoHistorico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idConvidado;

    private int idUsuario;

    private int treino;

    private Date data;


    public TreinoConjuntoHistorico(int idUsuario, int idConvidado, Date data) {
        this.id = id;
        this.idConvidado = idConvidado;
        this.idUsuario = idUsuario;
        this.treino = treino;
        this.data = data;
    }

    public TreinoConjuntoHistorico() {
        this.id = id;
        this.idConvidado = idConvidado;
        this.idUsuario = idUsuario;
        this.treino = treino;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConvidado() {
        return idConvidado;
    }

    public void setIdConvidado(int idConvidado) {
        this.idConvidado = idConvidado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTreino() {
        return treino;
    }

    public void setTreino(int treino) {
        this.treino = treino;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}

