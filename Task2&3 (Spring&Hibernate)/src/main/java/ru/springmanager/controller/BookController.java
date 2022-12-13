package ru.springmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.springmanager.model.Book;
import ru.springmanager.model.NoSuchBookException;

import java.util.List;


@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;

    @GetMapping("/findall")
    public String findAll(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "all_books";
    }

    @GetMapping("/{bookId}")
    public String showBook(
            @PathVariable("bookId") Integer bookId,
            Model model) throws NoSuchBookException {
        Book b = bookService.find(bookId);
        if (b!=null){
            model.addAttribute("book", b);
            return "book";
        }else{
            throw new NoSuchBookException("Error book id");
        }
    }


    @GetMapping("/findBooksByTitle")
    public String findBooksByName(Model model){
        return "find_books";
    }

    @PostMapping("/findBooksByTitle")
    public String showBooksByName(Model model, RedirectAttributes attr,
                                  @RequestParam(name = "booktitle") String title, Pageable page) {
        Page<Book> books = bookService.findBookByTitle(title, page);
        model.addAttribute("books", books);
        return "all_books";
    }




}
