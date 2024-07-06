package me.emma.service;

import me.emma.entity.Book;
import me.emma.entity.Status;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Optional<Book> updateBookStatus(Long id, Status status);

    Optional<Book> getBookById(Long id);

    Book saveBook(Book book);

    Optional<Book> updateBook(Book book);

    boolean deleteBookById(Long id);
}
