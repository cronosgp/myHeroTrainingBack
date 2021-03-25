package com.ifsp.MyHeroTraining.Models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
public class TreinoConjunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idConvidado;

    private int idUsuario;

    @Column(columnDefinition="DATE DEFAULT SYSDATE")
    private Date data;

    private Boolean status;

    private Boolean aguardando;

    public TreinoConjunto(int idUsuario, int idConvidado) {
        this.id = id;
        this.idConvidado = idConvidado;
        this.idUsuario = idUsuario;
        this.aguardando = false;
        this.data = data;
        this.status = status;
    }

    public TreinoConjunto() {
        this.id = id;
        this.idConvidado = idConvidado;
        this.idUsuario = idUsuario;
        this.aguardando = aguardando;
        this.data = data;
        this.status = status;
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

    public Boolean getAguardando() {
        return aguardando;
    }

    public void setAguardando(Boolean aguardando) {
        this.aguardando = aguardando;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

