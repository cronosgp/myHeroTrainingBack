package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.ConfirmationToken;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.ConfirmationTokenRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
public class ConfirmEmailController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private UsuarioRepository UsuarioRepository;

    @PostMapping
    public ResponseEntity confirmUserAccount(@RequestBody String confirmationToken,@RequestHeader(value = "accept-language",required = true) String language) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        logger.info("chamou confirmacao");
        logger.info(confirmationToken);
        if (token != null) {
            try {
                Optional<Usuario> user = UsuarioRepository.findByEmail(token.getUser().getEmail());
                user.get().setEnable(true);
                UsuarioRepository.save(user.get());
                confirmationTokenRepository.delete(token);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
            e.printStackTrace();
                logger.info("nao encontrado");
                return ResponseEntity.badRequest().build();

            }
        } else {
            logger.info("token vazio");
            return ResponseEntity.badRequest().build();

        }
    }
}