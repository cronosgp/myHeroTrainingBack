package com.ifsp.MyHeroTraining.Models;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Time;
import java.util.Date;

public interface dados_solic {
    @JsonSetter("nome")
    String getNome();
    @JsonSetter("amg")
    String getamg();
    @JsonSetter("email")
    String getEmail();
    @JsonSetter("dataami")
    String getDataami();
    @JsonSetter("avatar")
    String getAvatar();



}
