package com.project.gestionemploi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.gestionemploi.Repository.RoleRepository;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        private RoleRepository roleRepository; // Ajout de l'injection du RoleRepository

        @Bean
        public static PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.csrf().disable()
                                .authorizeHttpRequests(
                                                (authorize) -> authorize.requestMatchers("/register/**").permitAll()
                                                                .requestMatchers("/index").permitAll()
                                                                // .requestMatchers("/sessions/**").permitAll()
                                                                

                                                                .requestMatchers("/classes","/diplomas" ,"users", "/classes/create",
                                                                                "/classes/update/{id}", "/classes{id}","/register/save")
                                                                .hasAnyAuthority("ROLE_EMPLOYE", "ROLE_ADMIN")

                                                                .requestMatchers("/parents", "/parents/create",
                                                                                "/parents/update/{id}", "/parents{id}")
                                                                .hasAnyAuthority("ROLE_EMPLOYE", "ROLE_ADMIN")

                                                                .requestMatchers("/students", "/students/create",
                                                                                "/students/update/{id}", "/students{id}")
                                                                .hasAnyAuthority("ROLE_EMPLOYE", "ROLE_ADMIN")

                                                                .requestMatchers("/modules", "/modules/create",
                                                                                "/modules/update/{id}", "/modules{id}")
                                                                .hasAnyAuthority("ROLE_EMPLOYE", "ROLE_ADMIN")

                                                                .requestMatchers("/sessions", "/sessions/create",
                                                                                "/sessions/update/{id}",
                                                                                "/sessions{id}")
                                                                .hasAnyAuthority("ROLE_EMPLOYE", "ROLE_ADMIN")

                                                                .requestMatchers("/diplomas", "/diplomas/create",
                                                                "/diplomas/update/{id}",
                                                                "/diplomas{id}")
                                                .hasAnyAuthority("ROLE_EMPLOYE", "ROLE_ADMIN")

                                                                .requestMatchers("/classes/delete/{id}",
                                                                                "/parents/delete/{id}",
                                                                                "/students/delete/{id}",
                                                                                "/sessions//delete/{id}",
                                                                                "/modules/delete/{id}",
                                                                                "/diplomas/delete/{id}")
                                                                                
                                                                .hasAuthority("ROLE_ADMIN")

                                                                .requestMatchers("/teachers", "/teachers/create",
                                                                                "/teachers/update/{id}",
                                                                                "/teachers{id}",
                                                                                "/teachers/delete/{id}")
                                                                .hasAuthority("ROLE_ADMIN")

                                                                .requestMatchers("/diplomas/**")
                                                                .hasAuthority("ROLE_ADMIN")

                                                                .requestMatchers("/dashboards/**").authenticated()
                                                                .requestMatchers("/registers").permitAll()
                                                                .requestMatchers("/css/**", "/js/**", "/images/**")
                                                                .permitAll()

                                                                .requestMatchers("/login/**").permitAll()
                                                                .requestMatchers(
                                                                                "/parents/**")
                                                                .hasAuthority("ROLE_ADMIN"))
                                .formLogin(
                                                form -> form
                                                                .loginPage("/login")
                                                                .loginProcessingUrl("/login")
                                                                .defaultSuccessUrl("/dashboards")
                                                                .permitAll())
                                .logout(
                                                logout -> logout
                                                                .logoutRequestMatcher(
                                                                                new AntPathRequestMatcher("/logout"))
                                                                .permitAll());
                return http.build();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth
                                .userDetailsService(userDetailsService)
                                .passwordEncoder(passwordEncoder());
        }
}
