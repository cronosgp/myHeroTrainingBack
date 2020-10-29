package com.ifsp.MyHeroTraining.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Treino_Usuario {
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId_fase() {
        return fase;
    }

    public void setId_fase(int id_fase) {
        this.fase = id_fase;
    }

    public int getId_usuario() {
        return usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.usuario = id_usuario;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  int fase;
    private int usuario;


}
