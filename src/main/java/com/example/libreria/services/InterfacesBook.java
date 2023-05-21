package com.example.libreria.services;

import com.example.libreria.models.Book;

import java.util.List;
import java.util.Optional;

public interface InterfacesBook {
    List<Book> getBookList ();
    public Optional<Book> findById(int isbn);
    void addBook(String Title, Double Price, String Autor);
    void deleteBook(int isbn);
    void editBook(int isbn, String Title, Double Price, String Autor );
}
