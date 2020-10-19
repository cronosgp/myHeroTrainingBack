package com.ifsp.MyHeroTraining.Controllers;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Forms.FaseAtualiza;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
@RestController
@RequestMapping("/fase")
public class FaseController {
    @Autowired
    private FaseRepository faseRepository;
    @Autowired
    private TreinoRepository treinoRepository;
    @GetMapping
    //("/fase")
    public List<Treino> listaTreinoFases(@RequestParam Integer id) {
        List<Treino> treinoFase = treinoRepository.findByFasesIdOrderById(id);
        return treinoFase;
    }
    @GetMapping("/treino")
    public List<Fase> lisIdtreino(@RequestParam Integer id) {
        List<Fase> listFases = faseRepository.findFasesByTreinoId(id);
        return listFases;
    }
    @PutMapping("/{id}")
    @Transactional
    public Treino UpdateFase(@PathVariable Integer id) {
        FaseAtualiza faseAtualiza = new FaseAtualiza();
        Treino treino = faseAtualiza.atualizar(id, treinoRepository);
        return treino;
    }

    @GetMapping("/recupera")
    public List<Fase> recuperaFase(int id){
        List<Fase> fase   = faseRepository.findById(id);
        return fase;

        }
    
    
    

}


