package com.ifsp.MyHeroTraining.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class FaseDia {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataTreino() {
        return dataTreino;
    }

    public void setDataTreino(Date dataTreino) {
        this.dataTreino = dataTreino;
    }

    public int getIdfase() {
        return idfase;
    }

    public void setIdfase(int idfase) {
        this.idfase = idfase;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public Date dataTreino;
    public int idfase;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int idUsuario;
}


