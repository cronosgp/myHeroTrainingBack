package com.ifsp.MyHeroTraining.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioFaseTempo {

	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_usuario;
    private int id_fase;
    private String tempo;
    

	public UsuarioFaseTempo() {
		
	}


	public UsuarioFaseTempo(int id_usuario, int id_fase, String tempo) {
	
		this.id_usuario = id_usuario;
		this.id_fase = id_fase;
		this.tempo = tempo;
	
	}
	
	
	public UsuarioFaseTempo(int id_usuario) {
		
		this.id_usuario = id_usuario;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_fase() {
		return id_fase;
	}
	public void setId_fase(int id_fase) {
		this.id_fase = id_fase;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
    
    
    



    
}
