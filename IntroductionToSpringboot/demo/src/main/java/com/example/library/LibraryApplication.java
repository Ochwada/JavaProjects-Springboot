package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringApplication: is a helper class to launch our Spring Boot app
 * @SpringBootApplication -> is a meta annotation that combines:
 *  - @Configuration : makes the class as a source of spring beans.
 *  - @EnableAutoConfiguration : enables automatic configuration based on classpath.
 *  - @ComponentScan : scans the packages for Spring Components e.g. @RestController, @Service e.t.c.
 */

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
