package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.DTO.CadastroUsuarioDto;
import com.ifsp.MyHeroTraining.Forms.CadastroUsuarioForms;
import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.repository.CadastraUsuarioRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cadastro-usuario")
public class CadastroUsuarioController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private CadastraUsuarioRepository cadastraUsuarioRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public Optional<CadastroUsuario> listaUsuario(@RequestParam int id) {

        Optional<CadastroUsuario> cadastroUsuarios = cadastraUsuarioRepository.findById(id);
        return cadastroUsuarios;
    }

    @GetMapping("/id")
    public ResponseEntity<Optional<CadastroUsuario>> listaUsuarioId (@RequestParam int id) {
       try {
           Optional<CadastroUsuario> cadastroUsuario = cadastraUsuarioRepository.findById(id);
           return ResponseEntity.ok(cadastroUsuario);
       }catch (Exception e){
           return  ResponseEntity.badRequest().build();
       }
    }

    @PostMapping
    public ResponseEntity<CadastroUsuarioDto> CadastroUsuario(@RequestBody @Valid CadastroUsuarioForms cadastroUsuarioForms, UriComponentsBuilder uriComponentsBuilder) {

        CadastroUsuario cadastroUsuario = cadastroUsuarioForms.converter();
        //valida se o email já foi cadastrado
        Optional<CadastroUsuario> existeCadastro = cadastraUsuarioRepository.findByEmail(cadastroUsuarioForms.getEmail());
        if (existeCadastro.isPresent()) {
            logger.info(existeCadastro.get().getEmail());
            logger.info("cadastroUsuarioForms.getEmail()");
            logger.info("ja existe");
            //caso já exista o email cadastrado é retornado a bad request para o cliente
            return ResponseEntity.badRequest().build();
        }
        cadastroUsuario.setSenha(passwordEncoder.encode(cadastroUsuario.getSenha()));
        cadastroUsuario.setSenhac(passwordEncoder.encode(cadastroUsuario.getSenhac()));
        cadastraUsuarioRepository.save(cadastroUsuario);
        URI uri = uriComponentsBuilder.path("/cadastro-usuario/{id}").buildAndExpand(cadastroUsuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new CadastroUsuarioDto(cadastroUsuario));
    }
}
