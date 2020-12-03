package com.ifsp.MyHeroTraining.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Date;

public interface RetornoFaseDia {
   @JsonGetter("idfase")
  Integer getIdfase();

   @JsonGetter("id")
   Integer getId();

   @JsonGetter("max")
    Date getMax();





}
