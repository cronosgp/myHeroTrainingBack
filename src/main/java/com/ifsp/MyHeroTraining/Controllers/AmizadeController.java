package com.ifsp.MyHeroTraining.Controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifsp.MyHeroTraining.Models.Amizade;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.AmizadeRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
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

    @GetMapping
    public List<Usuario> listaAmigos(@RequestParam int id) {

        List<Amizade> amizades = amizadeRepository.findAmizadeByUsuarioId(id);
        List<Usuario> listaAmizades = new ArrayList<>();

        for(Amizade e : amizades) {
            if (e.getUsuarioId() == id && usuarioRepository.findById(e.getAmizadeId()).isPresent()){
                listaAmizades.add(usuarioRepository.findById(e.getAmizadeId()).get());

            }else if (e.getAmizadeId() == id && usuarioRepository.findById(e.getUsuarioId()).isPresent()) {
                listaAmizades.add(usuarioRepository.findById(e.getUsuarioId()).get());
            }
        }
        return listaAmizades;

    }

    @GetMapping("/data")
    public ResponseEntity<String> getAmizadeData(@RequestParam int id) {
        HttpHeaders headers = new HttpHeaders();

        try {
            List<Amizade> amizades = amizadeRepository.findAmizadeByUsuarioId(id);

            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");

            Map<String, String> Datas  = new HashMap<>();
                for (Amizade e : amizades) {
                    String dataString = df.format(e.getDataAmizade());
                    if(e.getUsuarioId() == id) {
                        Datas.put(String.valueOf(e.getAmizadeId()),dataString);
                    } else if(e.getAmizadeId() == id) {
                        Datas.put(String.valueOf(e.getUsuarioId()),dataString);
                    }
                }
                Gson gson = new GsonBuilder().create();
                String resposta = gson.toJson(Datas);

                logger.info(resposta);

            return new ResponseEntity<>(resposta, headers, HttpStatus.OK);
        }catch (Exception e){
            logger.info(String.valueOf(e));
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/request")
    public List<Usuario> listaSolicitacaoAmigos(@RequestParam int id) {

            List<Amizade> amizades = amizadeRepository.findByAmizadeIdSolicitacoes(id);
            List<Usuario> listaAmizades = new ArrayList<>();

        for(Amizade e : amizades) {
            if (usuarioRepository.findById(e.getUsuarioId()).isPresent()) {
                    listaAmizades.add(usuarioRepository.findById(e.getUsuarioId()).get());
            }
        }
            return listaAmizades;

    }

    @PostMapping("/request")
    public ResponseEntity enviarSolicitacao(@RequestBody Map<String, String> params )  {

        int id = Integer.parseInt(params.get("usuarioid"));
        String email = params.get("email");

        logger.info(email + " " + id);


            List<Amizade> listaUsuario = amizadeRepository.findByUsuarioId(id);
        boolean lu = listaUsuario.isEmpty();
            Optional<Usuario> user = usuarioRepository.findByEmail(email);
            List<Amizade> listaAmizade = amizadeRepository.findByAmizadeId(user.get().getId());
        boolean la = listaAmizade.isEmpty();


        if(!lu || !la){
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
        int amizadeid = Integer.parseInt(params.get("amizadeid"));

    Optional<Amizade> amizade = amizadeRepository.findByAmizadeIdAndUsuarioId(amizadeid, usuarioid);
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

        if (amizadeRepository.findByAmizadeIdAndUsuarioId(amizadeid, usuarioid).isPresent()){
            Optional<Amizade> amizade = amizadeRepository.findByAmizadeIdAndUsuarioId(amizadeid, usuarioid);
            amizadeRepository.delete(amizade.get());

        } else if(amizadeRepository.findByAmizadeIdAndUsuarioId(usuarioid, amizadeid).isPresent()){
            Optional<Amizade> amizade = amizadeRepository.findByAmizadeIdAndUsuarioId(usuarioid, amizadeid);
            amizadeRepository.delete(amizade.get());
        }
        return ResponseEntity.ok().build();
    }
}