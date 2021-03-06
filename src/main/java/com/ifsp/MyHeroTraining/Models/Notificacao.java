package com.ifsp.MyHeroTraining.Models;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
//userDetails serve para dizer ao spring que essa entidade representa um usuário para autentocacap
public class Notificacao{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private String conteudo;
    private int idUsuario;

    public Notificacao(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Notificacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getUsuario() {
        return idUsuario;
    }

    public void setUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}