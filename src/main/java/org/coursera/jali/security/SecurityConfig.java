package org.coursera.jali.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


    @Configuration
    @EnableConfigurationProperties
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsServiceImpl userDetailsService;

        @Autowired
        private LoggingAccessDeniedHandler accessDeniedHandler;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/h2/**").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/home").permitAll()
                    .antMatchers("/leitores/**").hasAnyRole("ADMIN", "USER")
                    .antMatchers("/livros/**").hasAnyRole("ADMIN", "USER")
                    .and()
                    .csrf().disable()
                    .headers().frameOptions().disable()
                    //Configurações de login e logout
                    .and().formLogin().loginPage("/login").permitAll()
                    .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/?logout")
                    .permitAll()
                    //Configurações de acesso Negado
                    .and()
                    .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler);
        }


        @Override
        protected void configure(AuthenticationManagerBuilder builder) throws Exception {
            builder
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(new BCryptPasswordEncoder());
        }

    }


