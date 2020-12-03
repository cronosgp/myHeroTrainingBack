package com.ifsp.MyHeroTraining.Controllers;
import com.ifsp.MyHeroTraining.DTO.TokenDto;
import com.ifsp.MyHeroTraining.Forms.UsuarioAtualiza;
import com.ifsp.MyHeroTraining.Forms.UsuarioForms;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.Security.TokenService;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public void Dados(){

    }
    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid UsuarioForms form) {
            UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
        return ResponseEntity.ok(new TokenDto(token, "Bearer"));

    }
    @PutMapping("/{id}")
    @Transactional
    public Usuario UpdateFase(@PathVariable int id, @RequestBody UsuarioAtualiza usuarioAtualiza){
        Usuario usuario = usuarioAtualiza.atualizar(id,usuarioRepository);
        return usuario;
    }
}


