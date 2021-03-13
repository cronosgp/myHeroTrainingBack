package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Forms.AtualizaUsuarioTreinoForms;
import com.ifsp.MyHeroTraining.Forms.UsuarioForms;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TreinoRepository treinoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/id")
    public ResponseEntity <Optional<Usuario>> infoUsuario(@RequestParam String email) {
        try {
            Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
            return ResponseEntity.ok(usuario);
        }
        catch(Exception e) {
            return  ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity <Optional<Usuario>> listaUsuario(@RequestParam int id) {
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(id);
            return ResponseEntity.ok(usuario);
        }
        catch(Exception e) {
            return  ResponseEntity.badRequest().build();
        }
    }
    @PostMapping
    public ResponseEntity CadastroUsuarioLogin(@RequestBody  UsuarioForms usuarioForms, UriComponentsBuilder uriComponentsBuilder) {
        Random random = new Random();

        try {
          Usuario usuario = new Usuario();
          usuario.setSenha(passwordEncoder.encode(usuarioForms.getSenha()));
          int randomInt = random.nextInt(8 - 1) + 1;
          usuario.setAvatar(randomInt);
          usuario.setEmailUsuario(usuarioForms.getEmail());
          usuario.setNome(usuarioForms.getNome());
          usuario.setEnable(false);
          usuarioRepository.save(usuario);
          return ResponseEntity.ok().build();
      }
      catch(Exception e) {
          return  ResponseEntity.badRequest().build();
      }
    }
    @PostMapping("/{id}")
    public Treino UpdateUsuario(@PathVariable int id, @RequestBody AtualizaUsuarioTreinoForms atualizaUsuarioTreinoForms) {
        Treino treino = atualizaUsuarioTreinoForms.AtualizaId(id, usuarioRepository,treinoRepository);
        return treino;
    }

}