package com.ifsp.MyHeroTraining.Models;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.swagger.models.auth.In;

import java.sql.Time;

public interface DadosTreino {
    @JsonSetter("idt")
     Integer getIdt();
    @JsonSetter("descricaot")
     String getDescricaot();
    @JsonSetter("horast")
     Time getHorast();
    @JsonSetter("intensidadet")
     String getIntensidadet();
    @JsonSetter("nivelt")
     String getNivelt();
    @JsonSetter("nomet")
     String getNomet();
    @JsonSetter("treino_finalizadot")
     Boolean getTreino_finalizadot();
    @JsonSetter("urlt")
     String getUrlt();
    @JsonSetter("usuario_idt")
    Integer getUsuario_idt();

}
