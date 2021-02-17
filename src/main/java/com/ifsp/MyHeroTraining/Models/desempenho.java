package com.ifsp.MyHeroTraining.Models;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigInteger;
import java.util.Date;

public interface desempenho {
    @JsonSetter("sum")
    BigInteger getSum();
    @JsonSetter("datas")
    Date getDatas();
    @JsonSetter("emailusu")
    String getEmailUsu();
    @JsonSetter("id_usu")
    String getId_usu();
    @JsonSetter("nome_")
    String getNome_();
    @JsonSetter("pontos_soma")
    String getPontos_soma();

}
