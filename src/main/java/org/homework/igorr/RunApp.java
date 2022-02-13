package org.homework.igorr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication(scanBasePackages = "org.homework.igorr")
@ImportResource("classpath:app-config.xml")
public class RunApp {

    public static void main(String[] args) {
        SpringApplication.run(RunApp.class, args);
    }

}