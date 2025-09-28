package vn.iotstar.category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import vn.iotstar.category.config.StorageProperties;
import vn.iotstar.category.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CategoryCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryCrudApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args -> {
			storageService.init();
		});
	}
}
