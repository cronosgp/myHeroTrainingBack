package com.ifsp.MyHeroTraining.Controllers;
import com.ifsp.MyHeroTraining.Models.Teste;
import com.ifsp.MyHeroTraining.Models.aquecimento;
import com.ifsp.MyHeroTraining.Models.personalizado_usuario;
import com.ifsp.MyHeroTraining.Models.treinoPersonalizado_usuario;
import com.ifsp.MyHeroTraining.repository.TreinoPersonalizadoRepository;
import com.ifsp.MyHeroTraining.repository.TreinoPersonalizadoUsuarioRepository;
import com.ifsp.MyHeroTraining.repository.treinoPersonalizado_usu_feito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
        ("/treinoPersonalizado")
public class TreinoPersonalizadoController {
    @Autowired
    private  TreinoPersonalizadoRepository treinoPersonalizadoRepository;
    @Autowired
    private TreinoPersonalizadoUsuarioRepository treinoPersonalizadoUsuarioRepository;

    @Autowired
    private treinoPersonalizado_usu_feito treinoPersonalizado_usu_feito;
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
@PostMapping("/dados")
    public ResponseEntity salvarPersonalizado(@RequestBody personalizado_usuario personalizado_usuario) {

        try {
            treinoPersonalizado_usu_feito.save(personalizado_usuario);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<aquecimento>> buscaDados() {
        try {
            List<aquecimento> dados = treinoPersonalizadoRepository.findAll();
            return ResponseEntity.ok(dados);

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }

    }
   @GetMapping("/dadosUsuario")
    public  ResponseEntity<List<aquecimento>> dadosPersonalizadoUsuario(@RequestParam int id){
     try {
         List<aquecimento> retornoDados = treinoPersonalizadoRepository.findByIdusuario(id);
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
