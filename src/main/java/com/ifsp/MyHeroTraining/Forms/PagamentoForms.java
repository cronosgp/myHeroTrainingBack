package com.ifsp.MyHeroTraining.Forms;

import com.ifsp.MyHeroTraining.Models.Pagamento;

public class PagamentoForms {
	private float transactionAmount;
	private String token;
	private String description;
	private int installments;
	private String paymentMethodId;
	private String docType;
	private String docNumber;
	private String email;
	private String status_pagamento;
	private String DataPagamento;
	private String Nome;
	private String Sobrenome;
	private int IdUsuario;






	public int getIdUsuario() {
		return IdUsuario;
	}






	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}






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






	public String getStatus_pagamento() {
		return status_pagamento;
	}






	public void setStatus_pagamento(String status_pagamento) {
		this.status_pagamento = status_pagamento;
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

	public String getstatus_pagamento() {
		return status_pagamento;
	}






	public void setstatus_pagamento(String status_pagamento) {
		this.status_pagamento = status_pagamento;
	}





	public  Pagamento converter() {
		// TODO Auto-generated method stub
		return new Pagamento(transactionAmount, token, description ,installments ,paymentMethodId ,docType ,docNumber ,email, status_pagamento,DataPagamento, Nome,Sobrenome,IdUsuario);
	}

}