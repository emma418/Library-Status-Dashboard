package me.emma.repository;

import lombok.AllArgsConstructor;
import me.emma.entity.Book;
import me.emma.entity.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * seed some book data
 */

@Component
@AllArgsConstructor
public class DBSeeder implements CommandLineRunner {
    private final BookRepository bookRepository;


    @Override
    public void run(String... args) throws Exception {
        List<Book> books = List.of(
                Book.builder()
                        .title("1984")
                        .author("George Orwell")
                        .isbn("978-0451524935")
                        .genre("Dystopian")
                        .status(Status.AVAILABLE)
                        .build(),
                Book.builder()
                        .title("To Kill a Mockingbird")
                        .author("Harper Lee")
                        .isbn("978-0060935467")
                        .genre("Thriller")
                        .status(Status.BORROWED)
                        .build(),
                Book.builder()
                        .title("The Great Gatsby")
                        .author("F. Scott Fitzgerald")
                        .isbn("978-0743273565")
                        .genre("Fiction")
                        .status(Status.AVAILABLE)
                        .build()
        );
        bookRepository.saveAll(books);

        bookRepository.findAll().forEach((book ->
                System.out.println(book.getId() + " " + book.getTitle())
        ));
    }
}
