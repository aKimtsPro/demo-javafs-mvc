package bstorm.akimts.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/client/register").permitAll()
                .mvcMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/hotel/all")
                .failureUrl("/login?error=true")
            .and()
                .logout()
                .logoutSuccessUrl("/hotel/all");

        return http.build();
    }

}
