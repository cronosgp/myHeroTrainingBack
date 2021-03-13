package com.ifsp.MyHeroTraining.Models;

import com.fasterxml.jackson.annotation.JsonSetter;

public interface dadosClassificacao {
    @JsonSetter("idt")
    Integer getIdt();
    @JsonSetter("pontos")
    Integer getPontos();
    @JsonSetter("nomeusuario")
    String getNomeusuario();

}
