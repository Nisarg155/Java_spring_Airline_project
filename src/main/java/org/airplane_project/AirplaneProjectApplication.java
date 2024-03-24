package org.airplane_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = ("org.airplane_project.controller"))
public class AirplaneProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirplaneProjectApplication.class, args);
    }

}
