package bstorm.akimts.mvc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//
//        List<UserDetails> users = List.of(
//                User.builder()
//                        .username("user")
//                        .password( encoder.encode("pass") )
//                        .roles("USER")
//                        .authorities("READ", "ROLE_USER")
//                        .build(),
//                User.builder()
//                        .username("admin")
//                        .password( encoder.encode("pass") )
//                        .roles("ADMIN")
//                        .authorities("READ", "WRITE", "ROLE_ADMIN")
//                        .build()
//        );
//
//        return new InMemoryUserDetailsManager(users);
//    }

    // A partir de 2.7.X
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // LES DROITS:

        // - permitAll : tous les visiteurs (connectés ou pas)
        // - denyAll : personne
        // - authenticated : connecté
        // - anonymous : pas connecté
        // - hasRole : possède le rôle particulier (un rôle est une autorité commencant par ROLE_)
        // - hasAnyRole : possède au moins un des rôles mentionnés
        // - hasAuthority : possède l'authorité particulier
        // - hasAnyAuthorities : possède au moins une des authorités mentionnés

        // - not(): methode avant un droit donnée pour un chemin pour obtenir l'opposé


        // ROLES POSSIBLES:

        // - ADMIN
        // - USER

        // AUTHORITES POSSIBLES:

        // - RECUPERER
        // - MODIFIER

        // LIAISONS:

        // - ADMIN: RECUPERER et MODIFIER et ROLE_ADMIN
        // - USER: RECUPERER et ROLE_USER

        http.csrf()
                .ignoringAntMatchers("/h2-console/**");

        http.headers()
                .frameOptions().sameOrigin();

        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/hotel/add", "/hotel/{id:[0-9]+}/update").hasRole("MANAGER")
                // je peux utiliser:
                // - ? : joker pour 1 caractère
                // - * : joker pour de 0 à N caractères
                // - **: joker pour de 0 à N segments
                // - {pathVar:regex}: pattern regex pour un segment
                .mvcMatchers("/client/all").hasAuthority("ROLE_ADMIN")
                // /client/all ; /client/all/ ; /client/all.html
                .mvcMatchers("/hotel/add-room").hasAnyRole("MANAGER", "ADMIN")
                .mvcMatchers("/login", "/client/register").anonymous()
                .antMatchers("/hotel/{id:[0-9]+}/details", "/client/info").authenticated()
                .antMatchers("/space_not_for_managers_or_admins").not().hasAnyRole("MANAGER", "ADMIN")
                .anyRequest().permitAll();

        http.formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/client/info")
                    .failureUrl("/login?error=true")
            .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/hotel/all");

        log.info("security config ended");
        return http.build();
    }

}
