package com.ifsp.MyHeroTraining.Controllers;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Forms.FaseAtualiza;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
@RestController
@RequestMapping("api/fase")
public class FaseController {
    @Autowired
    private FaseRepository faseRepository;
    @Autowired
    private TreinoRepository treinoRepository;
    @GetMapping
    //("/fase")
    public ResponseEntity<List<Treino>> listaTreinoFases(@RequestParam Integer id) {
        try {
            List<Treino> treinoFase = treinoRepository.findByFasesIdOrderById(id);
            return ResponseEntity.ok(treinoFase);
        }
        catch(Exception e) {
            return  ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/treino/id")
    public ResponseEntity<List<Fase>> lisIdtreino(@RequestParam Integer id) {
        try {
            List<Fase> listFases = faseRepository.findFasesByTreinoId(id);
            return ResponseEntity.ok(listFases);
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

    @GetMapping("/id")
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


