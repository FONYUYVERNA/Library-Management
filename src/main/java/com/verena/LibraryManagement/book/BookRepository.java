package com.verena.LibraryManagement.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title=?1")
    Optional<Book> findBookByTitle(String title);
    @Query("SELECT b FROM Book b WHERE b.author=?1")
    Optional<Book> findBookByAuthor(String author);
}
