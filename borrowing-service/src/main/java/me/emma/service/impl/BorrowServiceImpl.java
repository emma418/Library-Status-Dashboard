package me.emma.service.impl;

import lombok.AllArgsConstructor;
import me.emma.dto.Book;
import me.emma.dto.Status;
import me.emma.feign.BookClient;
import me.emma.service.BorrowService;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class BorrowServiceImpl implements BorrowService {

    private final BookClient bookClient;
    @Override
    public String borrowBook(Long bookId) {
        Book book = bookClient.getBookById(bookId);
        if (Status.AVAILABLE.equals(book.getStatus())) {
            bookClient.updateBookStatus(bookId, "BORROWED");
            return "Book borrowed successfully";
        }
        return "Book is not available for borrowing";
    }

    @Override
    public String returnBook(Long bookId) {
        bookClient.updateBookStatus(bookId, "AVAILABLE");
        return "Book returned successfully.";
    }
}
