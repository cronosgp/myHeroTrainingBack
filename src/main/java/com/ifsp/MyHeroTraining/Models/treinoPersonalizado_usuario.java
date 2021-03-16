package com.ifsp.MyHeroTraining.Models;
import org.hibernate.exception.DataException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class treinoPersonalizado_usuario {
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public int getIdExercicio() {
        return idExercicio;
    }
    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int id;
    public int idusuario;
    public int idExercicio;

    public Date getData_treino() {
        return data_treino;
    }

    public void setData_treino(Date data_treino) {
        this.data_treino = data_treino;
    }

    public Date data_treino;


}
