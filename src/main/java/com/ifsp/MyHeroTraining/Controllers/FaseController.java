package com.ifsp.MyHeroTraining.Controllers;
import com.ifsp.MyHeroTraining.Models.DadosTreino;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Forms.FaseAtualiza;
import com.ifsp.MyHeroTraining.Models.Treino;

import com.ifsp.MyHeroTraining.Models.usuario_data_fase;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import com.ifsp.MyHeroTraining.repository.usuarioDataFaseRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fase")
public class FaseController {
    @Autowired
    private FaseRepository faseRepository;
    @Autowired
    private TreinoRepository treinoRepository;
    @Autowired
    private usuarioDataFaseRepository usuarioDataFaseRepository;
    @GetMapping

    //("/fase")
    public ResponseEntity<List<DadosTreino>> listaTreinoFases(@RequestParam Integer id) {
      /* try {
            List<Treino> treinoFase = treinoRepository.findByFasesIdOrderById(id);
            return ResponseEntity.ok(treinoFase);
        }*/
        try {
            List<DadosTreino> treinoFase = faseRepository.carregaDados(id);
            return ResponseEntity.ok(treinoFase);
        }

        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping("/treino")
    public ResponseEntity<Integer> lisIdtreino(@RequestParam Integer id) {
        try {
           Integer idTreino =  usuarioDataFaseRepository.fase(id);
           return ResponseEntity.ok(idTreino);
        }

        catch(Exception e) {
            return  ResponseEntity.badRequest().build();
        }

    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Treino> UpdateFase(@PathVariable Integer id) {
        FaseAtualiza faseAtualiza = new FaseAtualiza();
        try {
            Treino treino = faseAtualiza.atualizar(id, treinoRepository);
            return ResponseEntity.ok(treino);
        }
        catch(Exception e) {
            return  ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/recupera")
    public ResponseEntity <List<Fase>> recuperaFase(int id){
        try {
            List<Fase> fase = faseRepository.findById(id);
            return ResponseEntity.ok(fase);
        }
        catch(Exception e) {
            return  ResponseEntity.badRequest().build();
        }
        }

}


