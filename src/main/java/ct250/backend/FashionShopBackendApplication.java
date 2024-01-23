package ct250.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Configuration
@Slf4j
public class FashionShopBackendApplication {

	public static void main(String[] args) {
		log.info("Server is running...");
		SpringApplication.run(FashionShopBackendApplication.class, args);
	}

}
