package com.ifsp.MyHeroTraining.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class usuario_data_fase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public Date data_fim_fase;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int idUsuario;

    public int id_fase;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_fim_fase() {
        return data_fim_fase;
    }

    public void setData_fim_fase(Date data_fim_fase) {
        this.data_fim_fase = data_fim_fase;
    }



    public int getId_fase() {
        return id_fase;
    }

    public void setId_fase(int id_fase) {
        this.id_fase = id_fase;
    }




}
