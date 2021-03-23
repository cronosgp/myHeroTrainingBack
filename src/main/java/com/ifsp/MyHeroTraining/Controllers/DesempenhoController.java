package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.desempenho;
import com.ifsp.MyHeroTraining.Models.desempenho_dados;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/desempenho")


public class DesempenhoController {

    @Autowired
    TreinoRepository treinoRepository;
    @GetMapping
    public ResponseEntity<List<desempenho>>buscaDados(@RequestParam int id, Date d_ini, Date dt_fim, int filtro){
        try {
      
            List<desempenho> dadosDesempenho = treinoRepository.carregaDesempenho(id, d_ini, dt_fim, filtro);
         
            return ResponseEntity.ok(dadosDesempenho);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/dado")
    public ResponseEntity<List<desempenho_dados>> buscaDadosUsuario(int id){
        try{

            List<desempenho_dados> dadosUsu = treinoRepository.carregaDadosUsu(id);
                return  ResponseEntity.ok(dadosUsu);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();

        }

    }
}
