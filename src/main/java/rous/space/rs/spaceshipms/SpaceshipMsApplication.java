package rous.space.rs.spaceshipms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpaceshipMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceshipMsApplication.class, args);
		System.out.println("Hello my spaceship microservice");

	}

}
