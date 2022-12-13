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
public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAll(Pageable pageable);

    Page<Book> findBooksByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<Book> findBooksByAuthors(Page<Author> authors, Pageable pageable);


}
