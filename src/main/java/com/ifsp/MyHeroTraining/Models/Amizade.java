package com.ifsp.MyHeroTraining.Models;
import javax.persistence.*;
import javax.swing.text.StyledEditorKit;
import java.util.Date;

@Entity
public class Amizade {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int usuarioId;
    private int amizadeId;
    private Boolean status;
    private Date dataAmizade;

    public Amizade(int usuarioId, int amizadeId) {
        this.usuarioId = usuarioId;
        this.amizadeId = amizadeId;
        this.status = status;
        this.dataAmizade = new Date();
    }

    public Amizade() {
        this.id = id;
        this.usuarioId = usuarioId;
        this.amizadeId = amizadeId;
        this.status = status;
        this.dataAmizade = dataAmizade;
    }


    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getAmizadeId() {
        return amizadeId;
    }

    public void setAmizadeId(int amizadeId) {
        this.amizadeId = amizadeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDataAmizade() {
        return dataAmizade;
    }

    public void setDataAmizade(Date dataAmizade) {
        this.dataAmizade = dataAmizade;
    }
}
