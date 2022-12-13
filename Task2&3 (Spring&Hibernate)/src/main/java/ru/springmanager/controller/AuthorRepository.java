package ru.springmanager.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.springmanager.model.Author;
import ru.springmanager.model.Book;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Page<Author> findAll(Pageable pageable);
    List<Author> findAuthorsByFirstNameAndLastName(String firstname, String lastname, Pageable pageable);

    List<Author> findAuthorsByFirstNameOrLastName(String firstname, String lastname, Pageable pageable);
    Page<Author> findAuthorsByIdBetween(Integer i1, Integer i2, Pageable pageable);

    @Query("SELECT a FROM Author a")
    List<Author> findDistinctAuthors(Pageable page);
//    List<Author> findDistinctBy


}
