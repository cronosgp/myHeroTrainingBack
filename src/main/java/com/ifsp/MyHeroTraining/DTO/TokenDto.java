package com.ifsp.MyHeroTraining.DTO;

public class TokenDto {
    public TokenDto(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    private String token;
    private String tipo;
}
