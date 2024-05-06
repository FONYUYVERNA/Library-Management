package com.verena.LibraryManagement.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner bookcommandLineRunner(BookRepository repo){
        return args -> {
            Book book1 = new Book(
                    "Romeo and Juliet",
                    "Shakespeare",
                    LocalDate.of(2000, Month.NOVEMBER,4)
            );
            Book book2 = new Book("A Simple Path", "Lucinda Varday",  LocalDate.of(2000, Month.NOVEMBER,4));
            Book book3 = new Book("A Peep into the Past", "Vasant Navrekar",  LocalDate.of(2024, Month.APRIL,29));
            Book book4 = new Book("A tale of Two Gardens", "Octavio Paz",  LocalDate.of(2005, Month.JUNE,5));
            Book book5 = new Book("Romeo And Juliet", "Shakespeare",  LocalDate.of(1997, Month.NOVEMBER,16));
            Book book6 = new Book("Punished by His Love", "Lara Scott",  LocalDate.of(2010, Month.APRIL,10));
            Book book7 = new Book("Dominating CEO","Lana Sarvatore" ,  LocalDate.of(1985, Month.MAY,8));
            repo.saveAll(List.of(book1,book2,book3,book4,book5,book6,book7));
        };
    }
}
