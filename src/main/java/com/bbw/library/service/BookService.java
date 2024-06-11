package com.bbw.library.service;

import com.bbw.library.model.Book;
import com.bbw.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> book = this.bookRepository.findById(id);
        return book.orElse(null);
    }

    public Book addBook(Book book) {
        return this.bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> bookOptional = this.bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPages(bookDetails.getPages());
            book.setImg(bookDetails.getImg());
            book.setGenres(bookDetails.getGenres());
            book.setReleasedate(bookDetails.getReleasedate());
            return this.bookRepository.save(book);
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }
}
