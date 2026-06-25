package es.uah.serverFilmAffinity2.cucumber;

import es.uah.serverFilmAffinity2.ServerFilmAffinity2Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = ServerFilmAffinity2Application.class)
public class CucumberSpringConfiguration {
}
