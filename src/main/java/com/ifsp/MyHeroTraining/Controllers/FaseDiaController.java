package com.ifsp.MyHeroTraining.Controllers;
import com.ifsp.MyHeroTraining.DTO.RetornoFaseDia;
import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.FaseDia;
import com.ifsp.MyHeroTraining.repository.FaseDiaRepository;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Optional;
import java.util.List;
@RestController
@RequestMapping("/fasedia")
public class FaseDiaController {
    @Autowired
    private FaseDiaRepository faseDiaRepository;
    @GetMapping
   public RetornoFaseDia recuperaDia (@RequestParam int id){
         RetornoFaseDia dias = faseDiaRepository.findByIdUsuario(id);
        return dias;
      }
      @PutMapping
    @Transactional
    public FaseDia salvaDIa(@RequestBody FaseDia faseDia){
      /*  Optional<FaseDia> update = faseDiaRepository.findByidfaseAndIdUsuario(faseDia.getIdUsuario(),faseDia.getIdfase());
        if(update.isPresent()){
            FaseDia faseDia1 = update.get();
            faseDia1.setDataTreino(faseDia.dataTreino);
            return faseDia1;
        }
        else{*/
            FaseDia faseDia1 = faseDiaRepository.save(faseDia);
            return  faseDia1;
        }
    }

