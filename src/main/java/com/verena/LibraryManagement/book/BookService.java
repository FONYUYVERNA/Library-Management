package com.verena.LibraryManagement.book;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long bookId){
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id " + bookId + " does not exist");
        }
        return bookRepository.findById(bookId);
    }

    public void addNewBook(Book book){
        Optional<Book> bookOptional = bookRepository.findBookByTitle(book.getTitle());
        Optional<Book> bookOptional1 = bookRepository.findBookByAuthor(book.getAuthor());
        if(bookOptional.isPresent() && bookOptional1.isPresent()){
            throw new IllegalStateException("Book is available already");
       }
      bookRepository.save(book);
    }

    public void deleteBook(Long bookId){
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId,String title){
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("Book with id" + bookId + "does not exist"));
        if(title != null && !title.isEmpty() && !Objects.equals(book.getTitle(),title)){
            book.setTitle(title);
        }
        bookRepository.save(book);
    }
}
