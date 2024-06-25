package com.bbw.library.controller;

import com.bbw.library.model.Book;
import com.bbw.library.repository.BookRepository;
import com.bbw.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get/books")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/get/book/{id}")
    public Book getBookById(@PathVariable Long id) {
        return this.bookService.getBookById(id);
    }

    @PostMapping("/add/book")
    public Book addBook(@RequestBody Book book) {
        return this.bookService.addBook(book);
    }

    @PutMapping("/update/book")
    public Book updateBook(@RequestBody Book book) {
        return this.bookService.updateBook(book);
    }

    @DeleteMapping("/delete/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
    }
}
