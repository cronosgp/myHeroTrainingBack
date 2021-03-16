package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.Models.TreinoConjunto;
import com.ifsp.MyHeroTraining.Models.Treino_Usuario;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.CadastraUsuarioRepository;
import com.ifsp.MyHeroTraining.repository.TreinoConjuntoRepository;
import com.ifsp.MyHeroTraining.repository.TreinoUsuarioRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RequestMapping("/treino-conjunto")
@RestController
public class TreinoConjuntoController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @Autowired
    private TreinoConjuntoRepository treinoConjuntoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastraUsuarioRepository cadastraUsuarioRepository;

    @Autowired
    private TreinoUsuarioRepository treinoUsuarioRepository;

    @GetMapping("/request/free")
    public ResponseEntity liberaTreino(@RequestParam int id) {

        List<TreinoConjunto> treinos = treinoConjuntoRepository.findContatoAndUsuarioIdTrue(id);
        if(treinos.isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/request/day")
    public ResponseEntity checkTreino(@RequestParam int id){
        Date today = Calendar.getInstance().getTime();
        List<Treino_Usuario> treinos = treinoUsuarioRepository.findByDataRealizadaAndUsuario(today,id);

        if(treinos.isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


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
    public List<CadastroUsuario> listaSolicitacoesTreino(@RequestParam int id) {

        List<TreinoConjunto> treinoConjuntos = treinoConjuntoRepository.findByConvidadoIdSolicitacoes(id);

        List<CadastroUsuario> listatreinoConjuntos = new ArrayList<>();

        for(TreinoConjunto e : treinoConjuntos) {
                listatreinoConjuntos.add(cadastraUsuarioRepository.findByEmail(
                        usuarioRepository.findById(e.getIdUsuario()).get().getEmail()).get());
        }
        return listatreinoConjuntos;

    }

    @PostMapping("/request")
    public ResponseEntity enviarSolicitacao(@RequestBody Map<String, String> params )  {

        int idusuario = Integer.parseInt(params.get("usuarioid"));
        int idconvite = Integer.parseInt(params.get("conviteid"));

        Optional<CadastroUsuario> cus = cadastraUsuarioRepository.findById(idconvite);
        if(cus.isPresent()) {
            Optional<Usuario> us = usuarioRepository.findByEmail(cus.get().getEmail());

            List<TreinoConjunto> listaUsuario = treinoConjuntoRepository.findByIdUsuario(idusuario);
            List<TreinoConjunto> listaConvidado = treinoConjuntoRepository.findByIdConvidado(idusuario);

            if (listaUsuario.stream().anyMatch(e -> e.getIdConvidado() == us.get().getId()) ||
                    listaConvidado.stream().anyMatch(e -> e.getIdUsuario() == us.get().getId())) {
                return ResponseEntity.badRequest().build();
            }

            try {
                TreinoConjunto treinoConjunto = new TreinoConjunto(idusuario, us.get().getId());
                treinoConjunto.setStatus(false);
                treinoConjuntoRepository.save(treinoConjunto);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                logger.info(String.valueOf(e));
                e.printStackTrace();
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/accept")
    public ResponseEntity aceitarSolicitacao(@RequestBody Map<String, String> params ) {

        logger.info(String.valueOf(params.values()));
        int usuarioid = Integer.parseInt(params.get("usuarioid"));
        int conviteid = Integer.parseInt(params.get("conviteid"));
        try {
            Optional<CadastroUsuario> cus = cadastraUsuarioRepository.findById(usuarioid);
            Optional<Usuario> us = usuarioRepository.findByEmail(cus.get().getEmail());

            Optional<TreinoConjunto> treinoConjunto = treinoConjuntoRepository.findByContatoIdAndUsuarioId(conviteid, us.get().getId());

            treinoConjunto.get().setStatus(true);
            treinoConjuntoRepository.save(treinoConjunto.get());
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/reject")
    public ResponseEntity rejeitarSolicitacao(@RequestBody Map<String, String> params ) {

        logger.info(String.valueOf(params.values()));
        int usuarioid = Integer.parseInt(params.get("usuarioid"));
        int conviteid = Integer.parseInt(params.get("conviteid"));

        if (treinoConjuntoRepository.findByContatoIdAndUsuarioId(conviteid, usuarioid).isPresent()){
            Optional<TreinoConjunto> treinoConjunto = treinoConjuntoRepository.findByContatoIdAndUsuarioId(conviteid, usuarioid);
            treinoConjuntoRepository.delete(treinoConjunto.get());

        } else if(treinoConjuntoRepository.findByContatoIdAndUsuarioId(usuarioid, conviteid).isPresent()){
            Optional<TreinoConjunto> treinoConjunto = treinoConjuntoRepository.findByContatoIdAndUsuarioId(usuarioid, conviteid);
            treinoConjuntoRepository.delete(treinoConjunto.get());
        }
        return ResponseEntity.ok().build();
    }
}