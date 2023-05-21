package com.example.libreria.controller;

import org.springframework.ui.Model;

import com.example.libreria.models.Book;
import com.example.libreria.services.ServicesBook;
import com.example.libreria.services.ServicesBookshelves;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private ServicesBook servicesBook;
    @Autowired
    private ServicesBookshelves servicesBookshelves;

    private List<Book> bookList = new ArrayList<>();

    public BookController(ServicesBook servicesBook, ServicesBookshelves servicesBookshelves){
        this.servicesBook = servicesBook;
        this.servicesBookshelves = servicesBookshelves;
    }

    @GetMapping("/welcome")
    public String example(Model model) {
        model.addAttribute("persona", "desconoccido!");
        model.addAttribute("edad", 18);
        return "welcome";
    }
    @GetMapping("/books")
    public String books (Model model) {
        List<Book> books = servicesBook.getBookList();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/books/new")
    public RedirectView addBook(@ModelAttribute("book") Book book, Model model){
        servicesBook.save(book);
        return new RedirectView("/books");
    }
    @GetMapping("/books/edit")
    public String editBook(@PathVariable (required = false) int isbn, Model model) {
        // Buscar el libro por su ISBN
        if(isbn != 0) {
            Optional<Book> bookOptional = servicesBook.findById(isbn);
            Book book = bookOptional.orElseThrow(() ->
                    new RuntimeException("El libro no existe")
            );
            // Agregar el libro al modelo para mostrarlo en la vista
            model.addAttribute("book", book);
            return "editBook";
        }else {
            return "books";
        }

    }

    @PostMapping("/books/edit/{isbn}")
    public RedirectView saveBook(@ModelAttribute("book") Book book, @PathVariable int isbn, Model model) {
        String mensaje = new String ("null");
        if(!mensaje.equals("null")){
            model.addAttribute("mensaje", mensaje);
            return new RedirectView("/editBook" );
        }
        // Establecer el ISBN del libro con el valor proporcionado en la ruta
        book.setIsbn(isbn);
        // Guardar el libro actualizado en la base de datos mediante el servicio correspondiente
        servicesBook.save(book);
        return new RedirectView("/books");
    }
    @GetMapping("/books/delete/{isbn}")
    public RedirectView deleteBook(@PathVariable int isbn){
        servicesBook.deleteBook(isbn);
        return new RedirectView("/books");

    }


    


    








}
