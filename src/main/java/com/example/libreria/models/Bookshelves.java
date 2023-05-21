package com.example.libreria.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "bookshelve")
public class Bookshelves implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "category")
    public String Category;

    @ManyToOne
    @JoinColumn(name = "isbn_book")
    public Book isbn_book;


}