package Aqua.com.example.Aqua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "Aqua.com.example.Aqua.dao")
@EntityScan(basePackages = "Aqua.com.example.Aqua.model")
@ComponentScan(basePackages = { "Aqua.com.example.Aqua.dao", "Aqua.com.example.Aqua" })
@SpringBootApplication
public class AquaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AquaApplication.class, args);
		
		
	}

}
