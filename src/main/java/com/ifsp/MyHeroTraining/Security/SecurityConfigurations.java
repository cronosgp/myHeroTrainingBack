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
import org.springframework.web.cors.CorsUtils;

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
              .antMatchers(HttpMethod.POST, "/auth").permitAll()
              .antMatchers(HttpMethod.GET, "/auth").permitAll()
              .antMatchers(HttpMethod.POST, "/cadastro-usuario").permitAll()
              .antMatchers(HttpMethod.GET, "/cadastro-usuario").permitAll()
              .antMatchers(HttpMethod.GET, "/usuario/id").permitAll()
              .antMatchers(HttpMethod.POST, "/treinos").permitAll()
              .antMatchers(HttpMethod.GET, "/treinos").permitAll()
              .antMatchers(HttpMethod.POST, "/confirm-reset").permitAll()
              .antMatchers(HttpMethod.GET, "/confirm-account").permitAll()
              .antMatchers(HttpMethod.POST, "/confirm-account").permitAll()
              .antMatchers(HttpMethod.GET, "/friend").permitAll()
              .antMatchers(HttpMethod.POST, "/friend").permitAll()
              .antMatchers(HttpMethod.POST, "/email").permitAll()
              .antMatchers(HttpMethod.POST, "/friend/request").permitAll()
              .antMatchers(HttpMethod.GET, "/friend/request").permitAll()
              .antMatchers(HttpMethod.POST, "/friend/accept").permitAll()
              .antMatchers(HttpMethod.POST, "/friend/reject").permitAll()
              .antMatchers(HttpMethod.POST, "/forgot-password").permitAll()
              .antMatchers(HttpMethod.GET,  "/swagger-ui/index.html").permitAll()
              .antMatchers(HttpMethod.POST,  "/swagger-ui").permitAll()
              .antMatchers(HttpMethod.PUT,  "/swagger-ui").permitAll()
              .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
              .anyRequest().authenticated()
              
              .and().csrf().disable()
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and().addFilterBefore(new AutenticationTokenFilter(tokenService,usuarioRepository), UsernamePasswordAuthenticationFilter.class);
                  }
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

  }
