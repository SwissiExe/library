package com.bbw.library.controller;

import com.bbw.library.model.Book;
import com.bbw.library.repository.BookRepository;
import com.bbw.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class BookController {

    private BookService bookService;

    @GetMapping("/get/books")
    public List<Book> getAllUsers() {
        return this.bookService.getAllBooks();
    }

}


