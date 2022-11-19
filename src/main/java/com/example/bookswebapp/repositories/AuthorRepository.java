package com.example.bookswebapp.repositories;

import com.example.bookswebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
