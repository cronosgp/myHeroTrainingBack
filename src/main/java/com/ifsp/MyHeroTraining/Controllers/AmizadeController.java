package com.ifsp.MyHeroTraining.Controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifsp.MyHeroTraining.Models.*;
import com.ifsp.MyHeroTraining.repository.AmizadeRepository;
import com.ifsp.MyHeroTraining.repository.CadastraUsuarioRepository;
import com.ifsp.MyHeroTraining.repository.TreinoConjuntoRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.checkerframework.checker.nullness.Opt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/friend")
@RestController
public class AmizadeController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TreinoConjuntoRepository treinoConjuntoRepository;

    @Autowired
    private CadastraUsuarioRepository cadastraUsuarioRepository;

    @GetMapping
    public List<CadastroUsuario> listaAmigos(@RequestParam int id) {

        List<Amizade> amizades = amizadeRepository.findAmizadeByUsuarioId(id);
        List<CadastroUsuario> listaAmizades = new ArrayList<>();

        for (Amizade e : amizades) {
            if (e.getUsuarioId() == id && usuarioRepository.findById(e.getAmizadeId()).isPresent() && cadastraUsuarioRepository.findByEmail(
                    usuarioRepository.findById(e.getAmizadeId()).get().getEmail()).isPresent()) {

                listaAmizades.add(cadastraUsuarioRepository.findByEmail(
                        usuarioRepository.findById(e.getAmizadeId()).get().getEmail()).get());

            } else if (e.getAmizadeId() == id && usuarioRepository.findById(e.getUsuarioId()).isPresent() && cadastraUsuarioRepository.findByEmail(
                    usuarioRepository.findById(e.getUsuarioId()).get().getEmail()).isPresent()) {

                listaAmizades.add(cadastraUsuarioRepository.findByEmail(
                        usuarioRepository.findById(e.getUsuarioId()).get().getEmail()).get());
            }
        }
        return listaAmizades;

    }

    @GetMapping("/data")
    public List<dados_amizade> getAmizadeData(@RequestParam int id) {
            List<dados_amizade> dados = amizadeRepository.amizade(id);
            return dados;

    }

    @GetMapping("/request")
    public List<CadastroUsuario> listaSolicitacaoAmigos(@RequestParam int id) {

            List<Amizade> amizades = amizadeRepository.findByAmizadeIdSolicitacoes(id);
        List<CadastroUsuario> listaAmizades = new ArrayList<>();

        for (Amizade e : amizades) {
            Optional<Usuario> us = usuarioRepository.findById(e.getUsuarioId());

            if (cadastraUsuarioRepository.findByEmail(us.get().getEmail()).isPresent()) {
                listaAmizades.add(cadastraUsuarioRepository.findByEmail(us.get().getEmail()).get());
            }
        }
        return listaAmizades;
    }

    @PostMapping("/request")
    public ResponseEntity<String> enviarSolicitacao(@RequestBody Map<String, String> params) {

        int id = Integer.parseInt(params.get("usuarioid"));
        String email = params.get("email");

        logger.info(email + " " + id);

        Optional<CadastroUsuario> existeEmail = cadastraUsuarioRepository.findByEmail(email);

        if (!existeEmail.isPresent()) {
                return ResponseEntity.ok().build();

        } else {
            List<Amizade> listaUsuario = amizadeRepository.findByUsuarioId(id);
            boolean lu = listaUsuario.isEmpty();
            Optional<Usuario> user = usuarioRepository.findByEmail(email);
            List<Amizade> listaAmizade = amizadeRepository.findByAmizadeId(user.get().getId());
            boolean la = listaAmizade.isEmpty();
            if (!lu || !la) {
                if (listaUsuario.stream().anyMatch(e -> e.getAmizadeId() == user.get().getId()) ||
                        listaAmizade.stream().anyMatch(e -> e.getUsuarioId() == id) ||
                        user.get().getId() == id) {
                    return ResponseEntity.badRequest().build();
                }
            }


            try {
                Amizade amizade = new Amizade(id, user.get().getId());
                amizade.setStatus(false);
                amizadeRepository.save(amizade);
                return ResponseEntity.ok("ok");
            } catch (Exception e) {
                logger.info(String.valueOf(e));
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
            }

        }

    }

    @PostMapping("/accept")
    public ResponseEntity aceitarSolicitacao(@RequestBody Map<String, String> params ) {

        logger.info(String.valueOf(params.values()));
        int usuarioid = Integer.parseInt(params.get("usuarioid"));
        int amizadeid = Integer.parseInt(params.get("amizadeid"));

        Optional<CadastroUsuario> cadusid = cadastraUsuarioRepository.findById(usuarioid);
        Optional<Usuario> us = usuarioRepository.findByEmail(cadusid.get().getEmail());


        Optional<Amizade> amizade = amizadeRepository.findByAmizadeIdAndUsuarioId(amizadeid, us.get().getId());
    logger.info(String.valueOf(amizade.isPresent()));

    amizade.get().setStatus(true);
    amizadeRepository.save(amizade.get());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reject")
    public ResponseEntity rejeitarSolicitacao(@RequestBody Map<String, String> params ) {

        logger.info(String.valueOf(params.values()));
        int usuarioid = Integer.parseInt(params.get("usuarioid"));
        int amizadeid = Integer.parseInt(params.get("amizadeid"));

        Optional<CadastroUsuario> cadusid = cadastraUsuarioRepository.findById(usuarioid);
        Optional<Usuario> us = usuarioRepository.findByEmail(cadusid.get().getEmail());
        Optional<TreinoConjunto> tc = treinoConjuntoRepository.findContatoAndUsuarioByOneId(usuarioid
        ,amizadeid);

        if (amizadeRepository.findByAmizadeIdAndUsuarioId(amizadeid, us.get().getId()).isPresent()){
            Optional<Amizade> amizade = amizadeRepository.findByAmizadeIdAndUsuarioId(amizadeid, us.get().getId());
            amizadeRepository.delete(amizade.get());

        } else if(amizadeRepository.findByAmizadeIdAndUsuarioId(us.get().getId(), amizadeid).isPresent()){
            Optional<Amizade> amizade = amizadeRepository.findByAmizadeIdAndUsuarioId(us.get().getId(), amizadeid);
            amizadeRepository.delete(amizade.get());
        }

        tc.ifPresent(treinoConjunto -> treinoConjuntoRepository.delete(treinoConjunto));

        return ResponseEntity.ok().build();
    }
}