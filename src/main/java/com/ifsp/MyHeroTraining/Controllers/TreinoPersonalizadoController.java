package com.ifsp.MyHeroTraining.Controllers;
import com.ifsp.MyHeroTraining.Models.Teste;
import com.ifsp.MyHeroTraining.Models.treinoPersonalizado;
import com.ifsp.MyHeroTraining.Models.treinoPersonalizado_usuario;
import com.ifsp.MyHeroTraining.repository.TreinoPersonalizadoRepository;
import com.ifsp.MyHeroTraining.repository.TreinoPersonalizadoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping
        ("/treinoPersonalizado")
public class TreinoPersonalizadoController {
    @Autowired
    TreinoPersonalizadoRepository treinoPersonalizadoRepository;
    @Autowired
    TreinoPersonalizadoUsuarioRepository treinoPersonalizadoUsuarioRepository;

    @PostMapping
    public ResponseEntity salvar(@RequestBody Teste teste) {

        try {
            treinoPersonalizado_usuario treinoPersonalizado = new treinoPersonalizado_usuario();
            treinoPersonalizado.setIdExercicio(teste.getExercicio());
            treinoPersonalizado.setIdusuario(teste.id);

            treinoPersonalizadoUsuarioRepository.save(treinoPersonalizado);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<treinoPersonalizado>> buscaDados() {
        try {
            List<treinoPersonalizado> dados = treinoPersonalizadoRepository.findAll();
            return ResponseEntity.ok(dados);

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }

    }
   @GetMapping("/dadosUsuario")
    public  ResponseEntity<List<treinoPersonalizado>> dadosPersonalizadoUsuario(@RequestParam int id){
     try {
         List<treinoPersonalizado> retornoDados = treinoPersonalizadoRepository.findByIdusuario(id);
         return ResponseEntity.ok(retornoDados);
     }
     catch (AuthenticationException e){
         return ResponseEntity.badRequest().build();
              }

    }
    @DeleteMapping("/apaga")
    public  ResponseEntity apagaTreino(  @RequestParam int id){
        try {
           treinoPersonalizadoUsuarioRepository.deleteByidusuario(id);
            return ResponseEntity.ok().build();
        }
        catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }

    }
}
