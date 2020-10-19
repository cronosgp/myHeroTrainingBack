package com.ifsp.MyHeroTraining.Forms;

import com.ifsp.MyHeroTraining.Models.Fase;
import com.ifsp.MyHeroTraining.Models.Treino;
import com.ifsp.MyHeroTraining.repository.FaseRepository;
import com.ifsp.MyHeroTraining.repository.TreinoRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
public class FaseAtualiza {
    public Treino atualizar(@NotNull Integer id, @NotNull TreinoRepository treinoRepository) {
        Treino treino = treinoRepository.getOne(id);
        treino.setTreinoFinalizado(true);
        return treino;
    }
}

