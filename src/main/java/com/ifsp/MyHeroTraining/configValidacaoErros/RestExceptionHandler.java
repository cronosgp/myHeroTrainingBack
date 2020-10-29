package com.ifsp.MyHeroTraining.configValidacaoErros;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DisabledException.class)
    @ResponseBody
    public ResponseEntity<String> handleException(DisabledException e) {
        logger.info("Disativado");
        logger.info(String.valueOf(ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error Message")));

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public ResponseEntity handleException(BadCredentialsException e) {
        logger.info("bad credentials");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
