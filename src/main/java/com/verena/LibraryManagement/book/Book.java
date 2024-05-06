package com.verena.LibraryManagement.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Book")
@Table(name = "book")
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence",
                       sequenceName = "book_sequence",
                       allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "bookid",
            updatable = false
    )
    private Long bookid;

    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;//title of book

    @Column(
            name = "author",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String author;//author of book

    @Column(
            name = "publicationYear",
            nullable = false
    )
    private LocalDate publicationYear;//Year book was publish

    boolean isAvailable;//indicates availability of book for borrowing

    public Book(String title, String author, LocalDate publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }


}
