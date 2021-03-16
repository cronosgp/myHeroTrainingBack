package com.ifsp.MyHeroTraining.Controllers;


import com.ifsp.MyHeroTraining.Models.Amizade;
import com.ifsp.MyHeroTraining.repository.AmizadeRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private AmizadeRepository amizadeRepository;

    @GetMapping
    public void listaUsuario(@RequestParam int id,@RequestHeader(value = "accept-language",required = true) String language) {
        List<Amizade> amizades = amizadeRepository.findByUsuarioId(id);

        return;
    }

}
