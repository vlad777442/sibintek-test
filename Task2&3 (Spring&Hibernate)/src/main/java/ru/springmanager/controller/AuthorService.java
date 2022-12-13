package ru.springmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.springmanager.model.Author;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findAuthorsByFirstNameAndLastName(String firstname, String lastname, Pageable page) {
        return authorRepository.findAuthorsByFirstNameAndLastName(firstname, lastname, page);
    }

    public List<Author> findAuthorsByFirstNameOrLastName(String firstname, String lastname, Pageable page) {
        return authorRepository.findAuthorsByFirstNameOrLastName(firstname, lastname, page);
    }

    public Page<Author> findByIdBetween(Integer d1, Integer d2, Pageable page) {
        if (d1 > d2) {
            return authorRepository.findAuthorsByIdBetween(d2, d1, page);
        }
        else return authorRepository.findAuthorsByIdBetween(d1, d2, page);

    }

    public List<Author> findDistinctAuthors(Pageable page) {
        return authorRepository.findDistinctAuthors(page);
    }
}
