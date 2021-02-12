package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.dadosClassificacao;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classificacao")
public class ClassificacaoController {
    @Autowired
    private TreinoRepository treinoRepository;
    @GetMapping
    public ResponseEntity<List<dadosClassificacao>> dadosClassificacaos (){
        try {
            List<dadosClassificacao> dadosClassific = treinoRepository.carregaDadosClassificao();
            return ResponseEntity.ok(dadosClassific);
        }
        catch (ArithmeticException e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
