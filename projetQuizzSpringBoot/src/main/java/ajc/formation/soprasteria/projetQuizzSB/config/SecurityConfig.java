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
            .antMatchers(HttpMethod.POST, "/api/compte/inscription").anonymous()
            .antMatchers(HttpMethod.PUT, "/api/compte/**/byadmin").hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/api/compte/all").hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/api/compte/profil**").hasAnyRole("ADMIN","UTILISATEUR")
            .antMatchers("").permitAll()
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
