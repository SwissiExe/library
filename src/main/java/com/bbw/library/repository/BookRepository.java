package com.bbw.library.repository;

import com.bbw.library.model.Book;
import com.bbw.library.service.BookService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
