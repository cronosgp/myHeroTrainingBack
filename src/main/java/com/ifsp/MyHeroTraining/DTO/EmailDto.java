package com.ifsp.MyHeroTraining.DTO;

import com.ifsp.MyHeroTraining.Models.EmailUsuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class EmailDto {
    @Email @NotEmpty @NotBlank
    private String email;

    public EmailDto(EmailUsuario emailUsuario) {
        this.id = emailUsuario.getId();
        this.email = emailUsuario.getEmail();
    }
    public EmailDto(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }



}
