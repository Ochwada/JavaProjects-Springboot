package com.example.companyhr;


import com.example.companyhr.model.Employee;
import com.example.companyhr.repo.EmployeeRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * *******************************************************
 * Package: com.example.companyhr
 * File: CompanyHrApplication.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 9:52 AM
 * Description: Entry point for the HR Application Spring Boot application.
 * Objective:
 * *******************************************************
 */

@SpringBootApplication
public class CompanyHrApplication {

    static {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        // Set all required secrets as system properties
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
    }

    public static void main(String[] args) {
     SpringApplication.run(CompanyHrApplication.class,args);

    }
    /**
     * Seeds the database with sample employees.
     */
    @Bean
    CommandLineRunner init(EmployeeRepository repo) {
        return args -> {
            repo.save(new Employee("Alice Smith", "HR", 50000.0));
            repo.save(new Employee("Bob Johnson", "Engineering", 70000.0));
            repo.save(new Employee("Charlie Brown", "Engineering", 80000.0));
            repo.save(new Employee("Diana Prince", "HR", 55000.0));
            repo.save(new Employee("Eve Adams", "Sales", 60000.0));
            repo.save(new Employee("Linda Och", "IT", 100000.0));
        };
    }
}
