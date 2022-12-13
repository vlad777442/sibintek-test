package ru.springmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.springmanager.model.Author;
import ru.springmanager.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book find(Integer id) {
        return bookRepository.findOne(id);
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Page<Book> findBookByTitle(String title, Pageable page) {
        return bookRepository.findBooksByTitleContainingIgnoreCase(title, page);
    }

//    public List<Book> findBooksByAuthors(Page<Author> author, Pageable page) {
//        List<Book> books = findAll();
//        List<Book> res = new ArrayList();
//        for (int i = 0; i < author.getSize(); i++) {
//            for (int j = 0; j < books.size(); j++) {
//                if (books.get(j).getAuthors().contains(author.getContent().get(i))) {
//                    res.add(books.get(j));
//                }
//            }
//        }
//        for (int i = 0; i < res.size(); i++)
//            System.out.println(res.get(i).toString());
//        return res;
//        return bookRepository.findBooksByAuthors(author, page);
//    }

//    public Page<Book> findBooksByAuthorsName(String first_name, String last_name, Pageable page) {
//        return bookRepository.findBooksByAuthors(first_name, last_name, page);
//    }
}
