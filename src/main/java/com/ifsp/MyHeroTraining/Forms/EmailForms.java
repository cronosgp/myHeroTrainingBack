package com.ifsp.MyHeroTraining.Forms;

import com.ifsp.MyHeroTraining.Models.EmailUsuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class EmailForms {
    @NotEmpty
    @NotBlank
    private String email;

    public EmailForms(EmailUsuario emailUsuario) {
        this.email = emailUsuario.getEmail();
    }

    public EmailForms(@NotEmpty @NotBlank String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public EmailUsuario converter(){
        return new EmailUsuario( email);
    }


}
