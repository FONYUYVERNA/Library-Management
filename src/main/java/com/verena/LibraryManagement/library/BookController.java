package com.verena.LibraryManagement.library;

import com.verena.LibraryManagement.book.Book;
import com.verena.LibraryManagement.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/library/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

   @GetMapping(path = "{bookId}")
    public Optional<Book> getBookById(@PathVariable("bookId") Long bookId){
       return bookService.getBookById(bookId);
    }

    @PostMapping
    public ResponseEntity<String> addNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book with id "+ book.getBookid() +" was add to the Library");
    }

    @DeleteMapping(path = "{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") Long bookId){

        bookService.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with id "+ bookId +" was deleted from the Library");
    }

    @PutMapping(path = "{bookId}")
    public ResponseEntity<String> updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String title
    ){

        bookService.updateBook(bookId,title);
        return ResponseEntity.status(HttpStatus.FOUND).body("Book with id "+ bookId +" was updated to "+title );
    }

}
