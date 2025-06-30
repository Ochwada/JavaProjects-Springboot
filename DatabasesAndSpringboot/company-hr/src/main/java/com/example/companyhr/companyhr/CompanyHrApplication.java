package com.example.companyhr.companyhr;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * *******************************************************
 * Package: com.example.companyhr.companyhr
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
}
