package com.ifsp.MyHeroTraining.Forms;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ifsp.MyHeroTraining.Models.UsuarioFaseTempo;

public class UsuarioFaseTempoForms {
   
	int id_fase;
	int id_usuario;
	String tempo;
	

	
	
	public int getId_fase() {
		return id_fase;
	}
	public void setId_fase(int id_fase) {
		this.id_fase = id_fase;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	
	public UsuarioFaseTempo converter() {
		
	return new UsuarioFaseTempo(id_usuario, id_fase, tempo);
	}
}
