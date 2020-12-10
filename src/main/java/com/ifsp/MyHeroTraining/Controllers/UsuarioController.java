package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Forms.AtualizaUsuarioTreinoForms;
import com.ifsp.MyHeroTraining.Forms.UsuarioForms;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
@RestController
@RequestMapping("api/usuario/id")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TreinoRepository treinoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity <List<Usuario>> listaUsuario(@RequestParam Long id) {
        try {
            List<Usuario> usuario = usuarioRepository.findById(id);
            return ResponseEntity.ok(usuario);
        }
        catch(Exception e) {
            return  ResponseEntity.badRequest().build();
        }
    }
    @PostMapping
    public ResponseEntity CadastroUsuarioLogin(@RequestBody  UsuarioForms usuarioForms, UriComponentsBuilder uriComponentsBuilder) {
      try {
          Usuario usuario = new Usuario();
          usuario.setSenha(passwordEncoder.encode(usuarioForms.getSenha()));
          usuario.setEmailUsuario(usuarioForms.getEmail());
          usuario.setEnable(false);
          usuarioRepository.save(usuario);
          return ResponseEntity.ok().build();
      }
      catch(Exception e) {
          return  ResponseEntity.badRequest().build();
      }
    }
    @PutMapping
    public Treino UpdateUsuario(@PathVariable int id, @RequestBody AtualizaUsuarioTreinoForms atualizaUsuarioTreinoForms) {
        Treino treino = atualizaUsuarioTreinoForms.AtualizaId(id, usuarioRepository,treinoRepository);
        return treino;
    }

}