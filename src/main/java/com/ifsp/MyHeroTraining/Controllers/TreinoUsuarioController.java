package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.DTO.CadastroUsuarioDto;
import com.ifsp.MyHeroTraining.Forms.AtualizaUsuarioTreinoForms;
import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.Models.Treino_Usuario;
import com.ifsp.MyHeroTraining.repository.TreinoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinousuario")
public class TreinoUsuarioController {

    @Autowired
    private TreinoUsuarioRepository treinoUsuarioRepository;

    @PostMapping
    public ResponseEntity<Treino_Usuario> UpdateUsuario(@RequestBody Treino_Usuario treino_usuario) {
        try {
            treinoUsuarioRepository.save(treino_usuario);
            return ResponseEntity.ok(treino_usuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    //criar método aqui para fazer insert de 3 meses na function

    @GetMapping("/recupera")
    public ResponseEntity<List<Treino_Usuario>> recuperaFase(@RequestParam int id, Date data) {
        List<Treino_Usuario> fase = treinoUsuarioRepository.findByDataRealizadaAndUsuario(data,id);
        try {
            return ResponseEntity.ok(fase);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
