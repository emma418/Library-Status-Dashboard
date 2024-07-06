package me.emma.service.impl;

import lombok.AllArgsConstructor;
import me.emma.entity.Book;
import me.emma.entity.Status;
import me.emma.repository.BookRepository;
import me.emma.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> updateBookStatus(Long id, Status status) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book bookToUpdate = book.get();
            bookToUpdate.setStatus(status);
            return Optional.ofNullable(bookRepository.save(bookToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        book.setStatus(Status.AVAILABLE);
        return bookRepository.save(book);
    }


    @Override
    public Optional<Book> updateBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findById(book.getId());
        if (bookOptional.isPresent()) {
            return Optional.ofNullable(bookRepository.save(book));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
