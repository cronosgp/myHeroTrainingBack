package com.ifsp.MyHeroTraining.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
    public class Treino_Usuario {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId_usuario() {
        return usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.usuario = id_usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int usuario;


    public Boolean getConjunto() {
        return conjunto;
    }

    public void setConjunto(Boolean conjunto) {
        this.conjunto = conjunto;
    }

    private Boolean conjunto;


    public Date getDataRealizada() {
        return dataRealizada;
    }

    public void setDataRealizada(Date dataRealizada) {
        this.dataRealizada = dataRealizada;
    }

    private Date dataRealizada;


    public int getId_exercicio() {
        return id_exercicio;
    }

    public void setId_exercicio(int id_exercicio) {
        this.id_exercicio = id_exercicio;
    }

    public int id_exercicio;

}