package com.ifsp.MyHeroTraining.Models;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigInteger;
import java.util.Date;

public interface desempenho_dados {
    @JsonSetter("email_")
    String getEmail_();
    @JsonSetter("nome_")
    String getNome_();
    @JsonSetter("pontos_soma")
    String getPontos_soma();

}
