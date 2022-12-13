package ru.springmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.springmanager.model.Author;
import ru.springmanager.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @GetMapping("/findallunique")
    public String findAll(Pageable page, Model model){
        List<Author> authors = authorService.findDistinctAuthors(page);
//        Page<Author> authors = authorRepository.findDistinct(page);
//        System.out.println(authors.toString());
//        System.out.println(authors.get(1).getBooks().toString());

        model.addAttribute("authors", authors);
        return "all_authors";
    }

    @GetMapping("/findall")
    public String findAll(Model model){
        List<Author> authors = authorService.findAll();
        System.out.println(authors.toString());

        model.addAttribute("authors", authors);
        return "all_authors";
    }

    @GetMapping(value="/findAuthorsById")
    public String findAuthor(Model model){
        return "find_authors";
    }

    @PostMapping(value="/findAuthorsById")
    public String findAuthor(Model model, RedirectAttributes attr, Pageable page,
                           @RequestParam(name = "rangestart") Integer rangestart,
                           @RequestParam(required = false, name = "rangeend") Integer rangeend) {

        Page<Author> authors = authorService.findByIdBetween(rangestart, rangeend, page);
        model.addAttribute("authors", authors);
        return "all_authors";

    }

    @GetMapping("/findBooksByAuthorsName")
    public String findBooksByAuthorsName(Model model){
        return "find_books_by_author";
    }

    @PostMapping("/findBooksByAuthorsName")
    public String showBooksByAuthorsName(Model model, RedirectAttributes attr,
                                         @RequestParam(name = "authorname") String name, Pageable page) {
        String[] names = name.split(" ");
        List<Author> authors;
        if (names.length == 2)
            authors = authorService.findAuthorsByFirstNameAndLastName(names[0], names[1], page);
        else if (names.length == 1){
            authors = authorService.findAuthorsByFirstNameOrLastName(names[0], "", page);
            authors.addAll(authorService.findAuthorsByFirstNameOrLastName("", names[0], page));
        }
        else
            authors = authorService.findAll();

//        System.out.println("Author "+ authors.toString());
//        for (int i = 0; i < authors.getSize(); i++)
//            System.out.println(authors.getContent().get(i).toString());

        List<Book> books = new ArrayList<>();
        System.out.println(authors.size());


//        System.out.println("Book get "+authors.getContent().get(0).getBooks().toString());
//        System.out.println("Book "+books.toString());
//        System.out.println(authors.getSize());
        for (int i = 0; i < authors.size(); i++) {
            books.addAll(authors.get(i).getBooks());
//            System.out.println(authors.getContent().get(i).toString());
        }

        model.addAttribute("books", books);
        return "all_books";
    }

}
