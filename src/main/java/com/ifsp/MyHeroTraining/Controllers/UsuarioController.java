package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Forms.AtualizaUsuarioTreinoForms;
import com.ifsp.MyHeroTraining.Forms.UsuarioForms;
import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TreinoRepository treinoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public  List<Usuario> listaUsuario(@RequestParam Long id) {
        List<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;
    }
    @PostMapping
    public void CadastroUsuarioLogin(@RequestBody  UsuarioForms usuarioForms, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = new Usuario();
        usuario.setSenha(passwordEncoder.encode(usuarioForms.getSenha()));
        usuario.setEmailUsuario(usuarioForms.getEmail());
        usuario.setEnable(false);
        usuarioRepository.save(usuario);
    }
    @PostMapping("/{id}")
    public Treino UpdateUsuario(@PathVariable int id, @RequestBody AtualizaUsuarioTreinoForms atualizaUsuarioTreinoForms) {
        Treino treino = atualizaUsuarioTreinoForms.AtualizaId(id, usuarioRepository,treinoRepository);
        return treino;
    }

}