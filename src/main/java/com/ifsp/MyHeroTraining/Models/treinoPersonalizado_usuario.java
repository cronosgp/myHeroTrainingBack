package com.ifsp.MyHeroTraining.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
