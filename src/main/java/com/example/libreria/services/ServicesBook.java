package com.example.libreria.services;

import com.example.libreria.models.Book;
import com.example.libreria.repository.RepositoryBook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesBook implements InterfacesBook {
    private  RepositoryBook repositoryBook;
    public ServicesBook(RepositoryBook repositoryBook){
        this.repositoryBook = repositoryBook;
    }

    @Override
    public List<Book> getBookList() {
        return repositoryBook.findAll();
    }

    @Override
    public Optional<Book> findById(int isbn) {
        return Optional.empty();
    }

    @Override
    public void addBook(String Title, Double Price, String Autor) {
        repositoryBook.addBook(Title, Price, Autor);
    }

    @Override
    public void deleteBook(int isbn) {
        repositoryBook.deleteBook(isbn);
    }

    @Override
    public void editBook(int isbn, String Title, Double Price, String Autor) {
        repositoryBook.editBook(isbn, Title, Price, Autor );
    }
    public void save(Book book){ repositoryBook.save(book);}

}
