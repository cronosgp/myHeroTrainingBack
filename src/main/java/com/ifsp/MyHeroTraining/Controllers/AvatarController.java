package com.ifsp.MyHeroTraining.Controllers;

import com.google.gson.Gson;
import com.ifsp.MyHeroTraining.DTO.CadastroUsuarioDto;
import com.ifsp.MyHeroTraining.Forms.CadastroUsuarioForms;
import com.ifsp.MyHeroTraining.Models.Avatar;
import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.AvatarRepository;
import com.ifsp.MyHeroTraining.repository.CadastraUsuarioRepository;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;


@RequestMapping("/perfil")
@RestController
public class AvatarController{
    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastraUsuarioRepository cadastraUsuarioRepository;

    @GetMapping(value = "/id")
    public ResponseEntity<Optional<CadastroUsuario>> getPerfil(@RequestParam int id){

        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Optional<CadastroUsuario> cadastroUsuario = cadastraUsuarioRepository.findByEmail(usuario.get().getEmail());

        if(cadastroUsuario.isPresent()){
            return ResponseEntity.ok(cadastroUsuario);
        }else{
            return  ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(value = "/avatar/id", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<String> getAvatarPorId(@RequestParam int id) {
        HttpHeaders headers = new HttpHeaders();

        Optional<CadastroUsuario> cus = cadastraUsuarioRepository.findById(id);

        try {
            Avatar av = avatarRepository.findById(cus.get().getAvatar());
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            return new ResponseEntity<>(av.getFile(), headers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/avatar/userid", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<String> getAvatarPorUserId(@RequestParam int id) {
        HttpHeaders headers = new HttpHeaders();

        Optional<Usuario> us = usuarioRepository.findById(id);
        Optional<CadastroUsuario> cus = cadastraUsuarioRepository.findByEmail(us.get().getEmail());

        try {
            Avatar av = avatarRepository.findById(cus.get().getAvatar());
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            return new ResponseEntity<>(av.getFile(), headers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/avatar")
    public ResponseEntity<String> getTodosAvatar() {
        HttpHeaders headers = new HttpHeaders();

        try {
            List<Avatar> av = avatarRepository.findAllByOrderByNameAsc();
            logger.info(av.get(0).getName());
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());

            String response = new Gson().toJson(av);
            return new ResponseEntity<>(response, headers, HttpStatus.OK);
        }catch (Exception e){
            logger.info(String.valueOf(e));
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(value = "/alterar")
    public ResponseEntity<CadastroUsuarioDto> CadastroUsuario(@RequestBody Map<String, String> params ) {

        HttpHeaders headers = new HttpHeaders();

        String email = params.get("email");
        String nome = params.get("nome");
        String contato = params.get("contato");
        String contato2 = params.get("contato2");
        //String altura = params.get("altura");
        //String peso = params.get("peso");
        int id = Integer.parseInt(params.get("id"));
        int avatar = Integer.parseInt(params.get("avatar"));

        try {

            Optional<Usuario> user = usuarioRepository.findByEmail(email);

            Optional<CadastroUsuario> usuario = cadastraUsuarioRepository.findByEmail(email);

            CadastroUsuario us = usuario.get();

            us.setEmail(email);
            us.setNome(nome);
            us.setContato(contato);
            us.setContato2(contato2);
            us.setAvatar(avatar);
            //usuario.get().setAltura(altura);
            //usuario.get().setPeso(peso);
            cadastraUsuarioRepository.save(us);

            user.get().setNome(nome);
            usuarioRepository.save(user.get());

            return new ResponseEntity<>(headers, HttpStatus.OK);

        }catch (Exception e){
            logger.info(String.valueOf(e));

            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

    }

}
