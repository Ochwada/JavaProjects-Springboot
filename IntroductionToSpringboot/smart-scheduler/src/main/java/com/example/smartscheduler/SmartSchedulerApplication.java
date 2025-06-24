package com.example.smartscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * *******************************************************
 * Package: com.example.smartscheduler
 * File: SmartSchedulerApplication.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 11:44 AM
 * Description: The entry point for the SmartScheduler Spring Boot application.
 * * This class is responsible for bootstrapping the application and  enabling
 * * component scanning, auto-configuration, and Spring Boot features.
 * *  Note: To start the application, include a main method with
 * {@code SpringApplication.run(SmartSchedulerApplication.class, args);}
 * Objective:
 * *******************************************************
 */

/**
 * {@code @SpringBootApplication} – Combines:
 * - {@code @EnableAutoConfiguration} – Enables auto-configuration of Spring context.
 * - {@code @ComponentScan} – Scans for components in this package and sub-packages.
 * - {@code @SpringBootConfiguration} – Marks this as a Spring Boot application configuration class.
 * <p>
 * {@code @EnableScheduling}</b> – Enables support for scheduling via {@code @Scheduled} annotations
 */
@SpringBootApplication // Combines @EnableAutoConfiguration, @ComponentScan and @SpringBootConfiguration
@EnableScheduling // Enables support of @Scheduled annotation on specified method.
public class SmartSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SmartSchedulerApplication.class, args
        );
    }
}
