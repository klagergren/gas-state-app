package gsa;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"gsa","conversion"})
@SpringBootApplication
public class GasStateApp {

	public static void main(String[] args) {
		SpringApplication.run(GasStateApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			System.out.println("Welcome to GSA!");
			System.out.println("Available beans are: ");
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

}
