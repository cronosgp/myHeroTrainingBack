package com.ifsp.MyHeroTraining.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Caminhada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int usuario;
	public float Distancia;
	public String Tempo;
	public float Pontos;

	
	
	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public float getDistancia() {
		return Distancia;
	}

	public void setDistancia(float distancia) {
		Distancia = distancia;
	}

	public String getTempo() {
		return Tempo;
	}

	public void setTempo(String tempo) {
		Tempo = tempo;
	}

	public float  getPontos() {
		return Pontos;
	}

	public void setPontos(float  pontos) {
		Pontos = pontos;
	}

}
