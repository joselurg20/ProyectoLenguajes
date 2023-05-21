package com.example.libreria.repository;


import com.example.libreria.models.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositoryBook extends JpaRepository<Book, Long> {


    @Query(value = "select * from book", nativeQuery = true)
    public List<Book> findAll();

    @Query(value = "select * from Book where isbn = ?1", nativeQuery = true)
    public Optional<Book> findById(int isbn);

    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Book (Title, Price, Autor) values (:titulo, :precio, :autor)",
            nativeQuery = true)
    void addBook(@Param("titulo") String Title, @Param("precio") Double Price,
                    @Param("autor") String Autor);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM book WHERE isbn=:isbn", nativeQuery = true)
    void deleteBook(@Param("isbn") int isbn);

    @Modifying
    @Transactional
    @Query(value = "UPDATE book SET Title=:titulo, Price=:precio, Autor=:autor WHERE isbn=:isbn", nativeQuery = true)
    void editBook(@Param("isbn") int isbn, @Param("titulo") String Title,
                     @Param("precio") Double Price, @Param("autor") String Autor);


}
