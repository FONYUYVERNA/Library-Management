package com.verena.LibraryManagement.patron;

import com.verena.LibraryManagement.book.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Patron")
@Table(name = "patron")
public class Patron {
    @Id
    @SequenceGenerator(name = "patron_sequence",
                       sequenceName = "patron_sequence",
                       allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patron_sequence"
    )
    @Column(
            name = "patronid",
            updatable = false
    )
    private int patronid;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "age",
            nullable = false
    )
    private int age;

    public Patron(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
