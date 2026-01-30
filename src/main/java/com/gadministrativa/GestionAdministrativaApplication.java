package com.gadministrativa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * The main class for the Spring application.
 * Only configured thing here is the UTC in order to avoid problems with different time zones.
 */
@SpringBootApplication
public class GestionAdministrativaApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(GestionAdministrativaApplication.class, args);
    }
}
