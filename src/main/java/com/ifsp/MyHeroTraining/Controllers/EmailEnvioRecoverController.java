package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.ConfigEmail.EmailConfig;
import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.Models.ConfirmationToken;
import com.ifsp.MyHeroTraining.repository.CadastraUsuarioRepository;
import com.ifsp.MyHeroTraining.repository.ConfirmationTokenRepository;
import com.ifsp.MyHeroTraining.repository.EmailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/forgot-password")
public class EmailEnvioRecoverController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private CadastraUsuarioRepository cadastraUsuarioRepository;

    @PostMapping
    public ResponseEntity forgotUserPassword(@RequestBody String email) {
        JavaMailSender mailSender;
        EmailConfig em = new EmailConfig();
        mailSender = em.mailSender();
        logger.info(email);

        Optional<CadastroUsuario> existingUser = cadastraUsuarioRepository.findByEmail(email);
        logger.info(String.valueOf(existingUser.get()));
        if (existingUser.isPresent()) {
            try {
                // Create token
                ConfirmationToken confirmationToken = new ConfirmationToken(existingUser.get());

                // Save it
                confirmationTokenRepository.save(confirmationToken);

                // Create the email
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(existingUser.get().getEmail());
                mailMessage.setSubject("Password Reset!");
                mailMessage.setFrom("myherotraining@gmail.com");
                mailMessage.setText("To complete the password reset process, please click here: "
                        + "https://myhtraining.herokuapp.com/#/confirm-reset?token=" + confirmationToken.getConfirmationToken());

                // Send the email
                mailSender.send(mailMessage);
                logger.info("funciono");
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("nao funciono");
                return ResponseEntity.badRequest().build();
            }
        } else {
            logger.info("nao funciono");
            return ResponseEntity.badRequest().build();
        }
    }
}
