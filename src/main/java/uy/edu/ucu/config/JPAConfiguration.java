package uy.edu.ucu.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "uy.edu.ucu.model.PO")
@EnableJpaRepositories(basePackages = "uy.edu.ucu.repository")
public class JPAConfiguration {
}