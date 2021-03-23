package com.ifsp.MyHeroTraining.Models;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigInteger;
import java.util.Date;

public interface desempenho {
    @JsonSetter("qtd_pontos")
    BigInteger getQtd_pontos();
    @JsonSetter("data_realizada")
    Date getdata_realizada();
    @JsonSetter("data_realizada_caminhada")
    Date getdata_realizada_caminhada();
    @JsonSetter("usuario")
    String getusuario();
    @JsonSetter("nome")
    String getNome();
    @JsonSetter("parte_trabalhada")
    String getparte_trabalhada();
    @JsonSetter("distancia_caminhada")
    String getdistancia_caminhada();
    @JsonSetter("tempo_caminhada")
    String gettempo_caminhada();
    
}
