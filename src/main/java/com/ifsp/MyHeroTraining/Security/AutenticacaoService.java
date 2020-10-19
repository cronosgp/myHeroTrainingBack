package com.ifsp.MyHeroTraining.Security;

import com.ifsp.MyHeroTraining.Models.Usuario;
import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Optional <Usuario> usuario = usuarioRepository.findByEmail(username);
        if(usuario.isPresent()){
            return usuario.get();
        }
        throw new UsernameNotFoundException("Dados Inválidos!!");
    }

}
