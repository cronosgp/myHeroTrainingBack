package com.ifsp.MyHeroTraining.Models;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigInteger;
import java.util.Date;

public interface desempenho {
    @JsonSetter("qtd_pontos")
    BigInteger getqtd_pontos();
    @JsonSetter("data_realizada")
    Date getdata_realizada();
   
    @JsonSetter("usuario")
    String getusuario();
    @JsonSetter("nome")
    String getNome();
    @JsonSetter("distancia_caminhada")
    String getdistancia_caminhada();
    @JsonSetter("tempo_caminhada")
    String gettempo_caminhada();
  
}
