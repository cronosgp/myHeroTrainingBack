package com.ifsp.MyHeroTraining.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Pagamento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;

	private String DataPagamento;
	private String Nome;
	private String Sobrenome;
	 private float transactionAmount;
	 private String token;
	 private String description;
	 private int installments;
	 private String paymentMethodId;
	 private String docType;
	 private String docNumber;
	private String email;
	private String status_pagamento;

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	private int usuario;

	


	public String getDataPagamento() {
		return DataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		DataPagamento = dataPagamento;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	
	public int getNumeroComprado() {
		return numeroComprado;
	}

	public void setNumeroComprado(int numeroComprado) {
		this.numeroComprado = numeroComprado;
	}

	private int numeroComprado;
	
	
	
	public Pagamento() {
		
	}

	public Pagamento(float transactionAmount, String token,
			String description, int installments, String paymentMethodId, String docType, String docNumber,
			String email, String status_pagamento, String DataPagamento, String Nome, String Sobrenome,int IdUsuario) {
		
		this.id = id;
		this.Nome = Nome;
		this.Sobrenome = Sobrenome;
		this.usuario = IdUsuario;
		this.DataPagamento = DataPagamento;
		this.transactionAmount = transactionAmount;
		this.token = token;
		this.description = description;
		this.installments = installments;
		this.paymentMethodId = paymentMethodId;
		this.docType = docType;
		this.docNumber = docNumber;
		this.email = email;
		this.status_pagamento =status_pagamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus_pagamento() {
		return status_pagamento;
	}

	public void setStatus_pagamento(String status_pagamento) {
		this.status_pagamento = status_pagamento;
	}



	 
}
