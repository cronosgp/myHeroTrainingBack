package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.usuario_data_fase;
import com.ifsp.MyHeroTraining.repository.usuarioDataFaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/dataFase")
public class usuarioDataFaseController {
    @Autowired
    private usuarioDataFaseRepository usuarioDataFaseRepository;
    @PostMapping
    public ResponseEntity<usuario_data_fase> salvaDataFimFase(@RequestBody  usuario_data_fase dados){
        Optional<usuario_data_fase>existeRegistro = usuarioDataFaseRepository.findByIdUsuario(dados.getIdUsuario());
        if(existeRegistro.isPresent()) {
            usuario_data_fase usuario_data_fase1 = existeRegistro.get();
            if (usuario_data_fase1.id_fase != dados.id_fase) {
                usuario_data_fase usuario_data_fase = usuarioDataFaseRepository.save(dados);
                return ResponseEntity.ok(usuario_data_fase);
            }
        }
        else{
            usuario_data_fase usuario_data_fase = usuarioDataFaseRepository.save(dados);
            return ResponseEntity.ok(usuario_data_fase);
        }
        return ResponseEntity.ok(dados);
        }
}
