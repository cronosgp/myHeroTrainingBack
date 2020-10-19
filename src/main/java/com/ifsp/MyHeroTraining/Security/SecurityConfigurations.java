package com.ifsp.MyHeroTraining.Security;

import com.ifsp.MyHeroTraining.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.SecureRandom;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
    @Autowired
    private AutenticacaoService autenticacaoService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder(10, new SecureRandom());
        return encoder;
    }
     @Override
    //Configurações de autorização
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }
    //Método que libera controle de liberação de url para usuario logado e não logado
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //definição de requisições que precisam de autenticação
      http.authorizeRequests()
             // .antMatchers(HttpMethod.GET, "/treinos/*").authenticated()
              .antMatchers(HttpMethod.GET, "/treinos").permitAll()
              .antMatchers(HttpMethod.POST, "/auth").permitAll()
              .and().csrf().disable()
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and().addFilterBefore(new AutenticationTokenFilter(tokenService,usuarioRepository), UsernamePasswordAuthenticationFilter.class);
                  }
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

  }
