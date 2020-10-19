package com.ifsp.MyHeroTraining.Models;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
public class Usuario implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private static final long seriaVersionUID = 1L;
    private String nome;
    private String email;
    private String senha;
    private Boolean isEnable;
    private String token;
    @ManyToOne
    private Treino treino;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfils = new ArrayList<>();
    @OneToMany
    private List<Treino> treinos = new ArrayList<>();
    @OneToMany
    private List<Fase> fase = new ArrayList<>();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmailUsuario(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfils;
    }
    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getEnable();
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public List<Fase> getFase() {
        return fase;
    }

    public void setFase(List<Fase> fase) {
        this.fase = fase;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

}