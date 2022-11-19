package com.example.bookswebapp.bootstrap;

import com.example.bookswebapp.domain.Author;
import com.example.bookswebapp.domain.Book;
import com.example.bookswebapp.domain.Publisher;
import com.example.bookswebapp.repositories.AuthorRepository;
import com.example.bookswebapp.repositories.BookRepository;
import com.example.bookswebapp.repositories.PublisherRepositroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepositroy publisherRepositroy;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepositroy publisherRepositroy) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepositroy = publisherRepositroy;
    }

    @Override
    public void run(String... args) throws Exception {
        Author Alaa = new Author("Ahmed","Alaa");
        Book sui = new Book("Suiiiiii","123123");

        Publisher publisher = new Publisher();
        publisher.setName("Alaa");
        publisher.setAddress("zzz");
        publisher.setCity("zzz");

        publisherRepositroy.save(publisher);

        Alaa.getBooks().add(sui);
        sui.getAuthors().add(Alaa);

        sui.setPublisher(publisher);
        publisher.getBooks().add(sui);

        authorRepository.save(Alaa);
        bookRepository.save(sui);
        publisherRepositroy.save(publisher);

        Author rod = new Author("Islam","Alaa");
        Book NoEJB = new Book("hahahahah","123456789");

        rod.getBooks().add(NoEJB);
        NoEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(NoEJB);

        System.out.println("Publisher Number of Books:  " + publisher.getBooks().size());
        System.out.println("Number of Books:- " + bookRepository.count());
    }
}
