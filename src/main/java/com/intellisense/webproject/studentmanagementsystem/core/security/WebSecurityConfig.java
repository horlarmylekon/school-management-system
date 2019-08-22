package com.intellisense.webproject.studentmanagementsystem.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.antMatcher("/admin/**")
                .authorizeRequests()
                .anyRequest()
                .fullyAuthenticated()
                .and()

                .formLogin().loginPage("/admin/login").permitAll()
                .loginProcessingUrl("/admin/login/process")
                .defaultSuccessUrl("/admin/dashboard", true).failureUrl("/admin/login?failed=true")
                .and()

                .logout().logoutUrl("/admin/logout")
                .logoutSuccessUrl("/").deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and().csrf().disable()
                .sessionManagement()
                .invalidSessionUrl("/admin/login")
                .maximumSessions(1)
                .expiredUrl("/admin/login?expired=true");


    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {

        webSecurity.ignoring().antMatchers("/", "/home/**", "/password/**", "/username/retrieve", "/resources/**", "/static/**", "/assets/**", "/fonts/**", "/css/**", "/js/**", "/img/**", "/images/**");

    }
}