package ct250.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = {"ct250.backend.user"})
@EntityScan(basePackages = "ct250.backend.user")
@EnableJpaRepositories(basePackages  = "ct250.backend.user")
@Configuration
@Slf4j
public class FashionShopBackendApplication {

	public static void main(String[] args) {
		log.info("Server is running...");
		SpringApplication.run(FashionShopBackendApplication.class, args);
	}

}
