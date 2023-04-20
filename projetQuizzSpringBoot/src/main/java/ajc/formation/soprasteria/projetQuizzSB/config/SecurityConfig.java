package ajc.formation.soprasteria.projetQuizzSB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //@formatter:off
		return http.antMatcher("/api/**")
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //compte
                .antMatchers(HttpMethod.POST, "/api/compte/inscription").anonymous()
                .antMatchers(HttpMethod.PUT, "/api/compte/**/byadmin").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/compte/all").hasAnyRole("ADMIN") //acces à la liste des comptes
                .antMatchers(HttpMethod.GET, "/api/compte/profil**").hasAnyRole("ADMIN","UTILISATEUR") //acces aux profils individuels
                //theme
                .antMatchers(HttpMethod.POST, "/api/theme").hasAnyRole("ADMIN") //acces à la creation de question
                .antMatchers(HttpMethod.PUT, "/api/theme/**").hasAnyRole("ADMIN") //acces à la creation de question
                .antMatchers(HttpMethod.DELETE, "/api/theme/**").hasAnyRole("ADMIN") //acces à la creation de question
                //question
                .antMatchers(HttpMethod.POST, "/api/question").hasAnyRole("ADMIN") //acces à la creation de question
                .antMatchers(HttpMethod.PUT, "/api/question/**").hasAnyRole("ADMIN") //acces à la modif de question
                .antMatchers(HttpMethod.DELETE, "/api/question/**").hasAnyRole("ADMIN") //acces à la suppression de question
                //reponse
                .antMatchers(HttpMethod.POST, "/api/reponse").hasAnyRole("ADMIN") //acces à la creation de question
                .antMatchers(HttpMethod.PUT, "/api/reponse/**").hasAnyRole("ADMIN") //acces à la modif de question
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .build();
//@formatter:on	
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
