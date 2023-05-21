package com.example.libreria.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn", nullable = false)
    private int isbn;

    @Column(name= "title")
    public String Title;

    @Column(name="price")
    public Double Price;

    @Column(name = "autor")
    public String Autor;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(name = "book_bookshelve",
            joinColumns = @JoinColumn(name = "isbn_book"),
            inverseJoinColumns = @JoinColumn(name = "id_bookshelve"))
    private List<Book> bookList = new ArrayList<>();




}
