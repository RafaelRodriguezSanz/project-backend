package uy.edu.ucu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Configuration
@EnableJpaRepositories(basePackages = "uy.edu.ucu.repositories")
@EnableTransactionManagement
@EntityScan(basePackages = "uy.edu.ucu.persistency.PO")
public class PostrgresConfigORM {
}
