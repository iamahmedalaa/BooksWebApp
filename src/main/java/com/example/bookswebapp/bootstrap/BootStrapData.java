package com.example.bookswebapp.bootstrap;

import com.example.bookswebapp.domain.Author;
import com.example.bookswebapp.domain.Book;
import com.example.bookswebapp.domain.Puplisher;
import com.example.bookswebapp.repositories.AuthorRepository;
import com.example.bookswebapp.repositories.BookRepository;
import com.example.bookswebapp.repositories.PuplisherRepositroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PuplisherRepositroy puplisherRepositroy;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PuplisherRepositroy puplisherRepositroy) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.puplisherRepositroy = puplisherRepositroy;
    }

    @Override
    public void run(String... args) throws Exception {
        Author Alaa = new Author("Ahmed","Alaa");
        Book sui = new Book("Suiiiiii","123123");
        Puplisher puplisher= new Puplisher();
        puplisher.setName("");
        puplisher.setAddress("");
        puplisher.setCity("");

        Alaa.getBooks().add(sui);
        sui.getAuthors().add(Alaa);

        authorRepository.save(Alaa);
        bookRepository.save(sui);
        puplisherRepositroy.save(puplisher);

        Author rod = new Author("Islam","Alaa");
        Book NoEJB = new Book("hahahahah","123456789");

        rod.getBooks().add(NoEJB);
        NoEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(NoEJB);

        System.out.println("Started in BootStrap");
        System.out.println("verify outPut: " + puplisherRepositroy.count());
        System.out.println("Number of Books:- " + bookRepository.count());
    }
}
