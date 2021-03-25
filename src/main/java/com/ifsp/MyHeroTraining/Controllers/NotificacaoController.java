package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.Notificacao;
import com.ifsp.MyHeroTraining.repository.NotificacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/not")
@RestController
public class NotificacaoController{
    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @GetMapping
    public ResponseEntity<List<Notificacao>> pegaNot(@RequestParam int id) {
        HttpHeaders headers = new HttpHeaders();

        List<Notificacao> not = notificacaoRepository.findByIdUsuario(id);

        return new ResponseEntity<>(not, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity deletaNot(@RequestBody int id) {
        HttpHeaders headers = new HttpHeaders();
        try {
            Optional<Notificacao> not = notificacaoRepository.findById(id);

            not.ifPresent(notificacao -> notificacaoRepository.delete(notificacao));

            return new ResponseEntity<>(headers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

    }

}