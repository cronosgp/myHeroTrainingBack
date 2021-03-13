package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.TreinoConjunto;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.TreinoConjuntoRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/treino-conjunto")
@RestController
public class TreinoConjuntoController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private TreinoConjuntoRepository treinoConjuntoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listaTreinosConjunto(@RequestParam int id) {

        List<TreinoConjunto> treinos = treinoConjuntoRepository.findContatoAndUsuarioIdTrue(id);
        List<Usuario> listaTreinos = new ArrayList<>();

        for(TreinoConjunto e : treinos) {
            if (e.getIdUsuario() == id && usuarioRepository.findById(e.getIdConvidado()).isPresent()){
                listaTreinos.add(usuarioRepository.findById(e.getIdConvidado()).get());

            }else if (e.getIdConvidado() == id && usuarioRepository.findById(e.getIdConvidado()).isPresent()) {
                listaTreinos.add(usuarioRepository.findById(e.getIdUsuario()).get());
            }
        }
        return listaTreinos;

    }

    @GetMapping("/request")
    public List<Usuario> listaSolicitacoesTreino(@RequestParam int id) {

        List<TreinoConjunto> treinoConjuntos = treinoConjuntoRepository.findByConvidadoIdSolicitacoes(id);
        List<Usuario> listatreinoConjuntos = new ArrayList<>();
        for(TreinoConjunto e : treinoConjuntos) {
            if (usuarioRepository.findById(e.getIdUsuario()).isPresent()) {
                listatreinoConjuntos.add(usuarioRepository.findById(e.getIdUsuario()).get());
            }
        }
        return listatreinoConjuntos;

    }

    @PostMapping("/request")
    public ResponseEntity enviarSolicitacao(@RequestBody Map<String, String> params )  {

        int iduser = Integer.parseInt(params.get("usuarioid"));
        int idconvite = Integer.parseInt(params.get("conviteid"));

        List<TreinoConjunto> listaUsuario = treinoConjuntoRepository.findByIdUsuario(iduser);
        List<TreinoConjunto> listaConvidado = treinoConjuntoRepository.findByIdConvidado(iduser);

        if (listaUsuario.stream().anyMatch(e -> e.getIdConvidado() == idconvite) ||
                listaConvidado.stream().anyMatch(e -> e.getIdUsuario() == idconvite)) {
            return ResponseEntity.badRequest().build();
        }

        try {
            TreinoConjunto treinoConjunto = new TreinoConjunto(iduser, idconvite);
            treinoConjunto.setStatus(false);
            treinoConjuntoRepository.save(treinoConjunto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.info(String.valueOf(e));
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/accept")
    public ResponseEntity aceitarSolicitacao(@RequestBody Map<String, String> params ) {

        logger.info(String.valueOf(params.values()));
        int usuarioid = Integer.parseInt(params.get("usuarioid"));
        int treinoConjuntoid = Integer.parseInt(params.get("treinoConjuntoid"));

        Optional<TreinoConjunto> treinoConjunto = treinoConjuntoRepository.findByContatoIdAndUsuarioId(treinoConjuntoid, usuarioid);
        logger.info(String.valueOf(treinoConjunto.isPresent()));

        treinoConjunto.get().setStatus(true);
        treinoConjuntoRepository.save(treinoConjunto.get());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reject")
    public ResponseEntity rejeitarSolicitacao(@RequestBody Map<String, String> params ) {

        logger.info(String.valueOf(params.values()));
        int usuarioid = Integer.parseInt(params.get("usuarioid"));
        int treinoConjuntoid = Integer.parseInt(params.get("treinoConjuntoid"));

        if (treinoConjuntoRepository.findByContatoIdAndUsuarioId(treinoConjuntoid, usuarioid).isPresent()){
            Optional<TreinoConjunto> treinoConjunto = treinoConjuntoRepository.findByContatoIdAndUsuarioId(treinoConjuntoid, usuarioid);
            treinoConjuntoRepository.delete(treinoConjunto.get());

        } else if(treinoConjuntoRepository.findByContatoIdAndUsuarioId(usuarioid, treinoConjuntoid).isPresent()){
            Optional<TreinoConjunto> treinoConjunto = treinoConjuntoRepository.findByContatoIdAndUsuarioId(usuarioid, treinoConjuntoid);
            treinoConjuntoRepository.delete(treinoConjunto.get());
        }
        return ResponseEntity.ok().build();
    }
}