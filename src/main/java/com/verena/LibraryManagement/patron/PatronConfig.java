package com.verena.LibraryManagement.patron;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class PatronConfig {
    @Bean
    CommandLineRunner patroncommandLineRunner(PatronRepository repository) {
        return args -> {
            Patron patron1 = new Patron("Fonyuy Verena", 21);
            Patron patron2 = new Patron("Lami Boris", 28);
            Patron patron3 = new Patron("Burinyuy Cedric", 32);
            Patron patron4 = new Patron("Berinyuy Casilda", 18);
            Patron patron5 = new Patron("Kewir Bertin", 23);
            repository.saveAll(List.of(patron1,patron2,patron3,patron4,patron5));
        };
    }
}
