package com.example.bookswebapp.repositories;

import com.example.bookswebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
