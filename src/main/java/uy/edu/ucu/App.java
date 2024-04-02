package uy.edu.ucu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@ImportResource("classpath:beans.xml")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}