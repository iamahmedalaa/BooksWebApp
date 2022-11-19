package com.example.bookswebapp.repositories;

import com.example.bookswebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepositroy extends CrudRepository<Publisher,Long> {
}
