package com.ifsp.MyHeroTraining.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class personalizado_usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdexercicio() {
        return idexercicio;
    }

    public void setIdexercicio(int idexercicio) {
        this.idexercicio = idexercicio;
    }

    public int idexercicio;


    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int usuario;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date data;
}
