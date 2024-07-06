package me.emma.controller;

import lombok.AllArgsConstructor;
import me.emma.entity.Book;
import me.emma.entity.Status;
import me.emma.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return book.get();
        }
        return new Book();
    }

    @PutMapping("/{id}/status")
    public String updateBookStatus(@PathVariable Long id, @RequestParam Status status) {
        Optional<Book> book = bookService.updateBookStatus(id, status);
        if (book.isPresent()) {
            return "Book status updated successfully";
        }
        return "Book with id " + id + " not found";
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        boolean flag = bookService.deleteBookById(id);
        if (flag) {
            return "Book with id " + id + " deleted successfully";
        }
        return "Book with id " + id + " not found";
    }

    @PutMapping
    public String updateBook(@RequestBody Book book) {
        Optional<Book> updatedBook = bookService.updateBook(book);
        if(updatedBook.isPresent()) {
            return "Book was updated";
        }
        return "Book not found";
    }
}
