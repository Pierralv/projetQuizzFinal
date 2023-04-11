package projetQuizzRest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import projetQuizz.config.JpaConfig;

@Configuration
@EnableWebMvc
@ComponentScan("projetQuizzRest.restcontroller")
@Import(JpaConfig.class)
public class WebConfig {

}
