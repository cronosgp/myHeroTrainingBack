package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.Models.*;
import com.ifsp.MyHeroTraining.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
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

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private TreinoConjuntoHistoricoRepository treinoConjuntoHistoricoRepository;

    @Autowired
    private NotificacaoRepository notificacaoRepository;


    @GetMapping("/request/free")
    public ResponseEntity<Boolean> liberaTreino(@RequestParam int id) {
        Boolean response = null;
        HttpHeaders headers = new HttpHeaders();

        List<TreinoConjunto> treinos = treinoConjuntoRepository.findContatoAndUsuarioIdTrue(id);

        if (treinos.isEmpty()) {
            response = true;
            return new ResponseEntity<>(response, headers, HttpStatus.OK);
        } else {
            response = false;
            return new ResponseEntity<>(response, headers, HttpStatus.OK);
        }
    }

    @GetMapping("/request/friend")
    public ResponseEntity<Boolean> amigoJaFez(@RequestParam int id) {
        Boolean response = null;
        HttpHeaders headers = new HttpHeaders();

        List<TreinoConjunto> treinos = treinoConjuntoRepository.findContatoAndUsuarioIdTrueAguardando(id);

        response = treinos.isEmpty();
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @GetMapping("/convite")
    public ResponseEntity<List<TreinoConjunto>> conviteAceito(@RequestParam int id, Date data) {


        List<TreinoConjunto> treinos = treinoConjuntoRepository.findContatoAndUsuarioIdTrue(id, data);

        return ResponseEntity.ok(treinos);
    }

    @GetMapping("/request/day")
    public ResponseEntity<Boolean> checkTreino(@RequestParam int id) {
        Boolean response = null;
        HttpHeaders headers = new HttpHeaders();

        Date today = Calendar.getInstance().getTime();
        logger.info(String.valueOf(today));
        List<Treino_Usuario> treinos = treinoUsuarioRepository.findByDataRealizadaAndUsuarioAndConjuntoIsNull(today, id);


        response = treinos.isEmpty();
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @GetMapping("/request/last")
    public ResponseEntity<Boolean> checkUltimoTreino(@RequestParam int id, int idTreino) {

        Boolean response = null;
        HttpHeaders headers = new HttpHeaders();

        LocalDate date = LocalDate.now();
        Date today = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Treino_Usuario> treinos = treinoUsuarioRepository.findByDataRealizadaAndUsuarioAndAndId_exercicio(today, id, idTreino);
        List<TreinoConjunto> treinoConjuntos = treinoConjuntoRepository.findContatoAndUsuarioIdTrue(id);


        if (!treinos.isEmpty()) {
            if (!treinoConjuntos.isEmpty()) {
                List<TreinoConjuntoHistorico> treinoConjuntoHistoricos = treinoConjuntoHistoricoRepository.findContatoAndUsuarioAndData(treinoConjuntos.get(0).getIdUsuario(),
                        treinoConjuntos.get(0).getIdConvidado(), today);

                if (treinoConjuntoHistoricos.isEmpty()) {
                    TreinoConjuntoHistorico treinoConjuntoHistorico = new TreinoConjuntoHistorico(treinoConjuntos.get(0).getIdUsuario(),
                            treinoConjuntos.get(0).getIdConvidado(), today);
                    treinoConjuntos.get(0).setAguardando(true);
                    treinoConjuntoRepository.save(treinoConjuntos.get(0));
                    treinoConjuntoHistoricoRepository.save(treinoConjuntoHistorico);
                } else {
                    treinoConjuntoRepository.delete(treinoConjuntos.get(0));
                }

                response = !treinos.isEmpty();

            } else {
                response = true;
            }
        } else {
            response = false;
        }
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }


    @GetMapping
    public List<Usuario> listaTreinosConjunto(@RequestParam int id) {

        List<TreinoConjunto> treinos = treinoConjuntoRepository.findContatoAndUsuarioIdTrue(id);
        List<Usuario> listaTreinos = new ArrayList<>();

        for (TreinoConjunto e : treinos) {
            if (e.getIdUsuario() == id && usuarioRepository.findById(e.getIdConvidado()).isPresent()) {
                listaTreinos.add(usuarioRepository.findById(e.getIdConvidado()).get());

            } else if (e.getIdConvidado() == id && usuarioRepository.findById(e.getIdConvidado()).isPresent()) {
                listaTreinos.add(usuarioRepository.findById(e.getIdUsuario()).get());
            }
        }
        return listaTreinos;

    }

    @GetMapping("/resultado")
    public int resultado(@RequestParam int id) {

        Date today = Calendar.getInstance().getTime();
        int usuarioTotalPontos = 0;

        List<Treino_Usuario> treino_usuario1 = treinoUsuarioRepository.findByDataRealizadaAndUsuarioAndConjuntoIsNull(today, id);

        for (Treino_Usuario treino : treino_usuario1
        ) {
            Optional<Exercicio> ex = exercicioRepository.findOneById(treino.getId_exercicio());
            usuarioTotalPontos += ex.get().getQntd_pontos();
        }
        usuarioTotalPontos *= 2;
        return usuarioTotalPontos;

    }

    @GetMapping("/request")
    public List<dados_solic> listaSolicitacoesTreino(@RequestParam int id) {

        List<dados_solic> treinoConjuntos = treinoConjuntoRepository.solicitacoes(id);

        return treinoConjuntos;

    }

    @PostMapping("/request")
    public ResponseEntity enviarSolicitacao(@RequestBody Map<String, String> params) {

        int idusuario = Integer.parseInt(params.get("usuarioid"));
        int idconvite = Integer.parseInt(params.get("conviteid"));

            Optional<TreinoConjunto> listaTreino = treinoConjuntoRepository.findContatoAndUsuarioByOneId(idusuario, idconvite);

            if (listaTreino.isPresent()) {
                return ResponseEntity.badRequest().build();
            }else{

                try {
                    TreinoConjunto treinoConjunto = new TreinoConjunto(idusuario, idconvite);
                    treinoConjunto.setStatus(false);
                    treinoConjuntoRepository.save(treinoConjunto);
                    return ResponseEntity.ok().build();
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
        int conviteid = Integer.parseInt(params.get("conviteid"));
        try {
            Optional<TreinoConjunto> treinoConjunto = treinoConjuntoRepository.findByContatoIdAndUsuarioId(conviteid, usuarioid);

            treinoConjunto.get().setStatus(true);
            treinoConjunto.get().setData(new Date());
            treinoConjuntoRepository.save(treinoConjunto.get());

            Notificacao not = new Notificacao(usuarioid);
            not.setTipo("Alert");
            Optional<Usuario> conviteus = usuarioRepository.findById(conviteid);
            not.setConteudo("Seu amigo " + conviteus.get().getNome() + " aceitou treino em conjunto!");
            notificacaoRepository.save(not);

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