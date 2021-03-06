package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.DTO.CadastroUsuarioDto;
import com.ifsp.MyHeroTraining.Forms.AtualizaUsuarioTreinoForms;
import com.ifsp.MyHeroTraining.Models.*;
import com.ifsp.MyHeroTraining.repository.TreinoUsuarioRepository;
import com.ifsp.MyHeroTraining.repository.treinoPersonalizado_usu_feito;
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
    @Autowired
    private treinoPersonalizado_usu_feito  treinoPersonalizado_usu_feito;

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
    @GetMapping("/personalizado")
    public ResponseEntity<List<personalizado_usuario>> recuperaPesonalizado(@RequestParam Date data, int id) {

        try {
            List<personalizado_usuario> fase = treinoPersonalizado_usu_feito.findByusuarioAndData(id,data);
            return ResponseEntity.ok(fase);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
