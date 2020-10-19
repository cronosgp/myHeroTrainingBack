package com.ifsp.MyHeroTraining.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifsp.MyHeroTraining.Models.ConfirmationToken;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.ConfirmationTokenRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/confirm-reset")
public class ChangePasswordController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private UsuarioRepository UsuarioRepository;

    @PostMapping
    public ResponseEntity trocaSenha(@RequestBody String model) throws JsonProcessingException {
        Map<String, Object> jsonToMap = new ObjectMapper().readValue(model, Map.class);
        String confirmationToken = (String) jsonToMap.get("params");
        String password = (String) jsonToMap.get("pass");
        logger.info(model);
        logger.info(password);
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        logger.info("troca senha");
        logger.info(confirmationToken);
        if (token != null) {
            try {
                Optional<Usuario> user = UsuarioRepository.findByEmail(token.getUser().getEmail());
                user.get().setSenha(passwordEncoder.encode(password));
                UsuarioRepository.save(user.get());
                confirmationTokenRepository.delete(token);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("nao trocado");
                return ResponseEntity.badRequest().build();

            }
        } else {
            logger.info("token vazio");
            return ResponseEntity.badRequest().build();
        }
    }
}
