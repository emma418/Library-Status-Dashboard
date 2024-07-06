package me.emma.service;

public interface BorrowService {
    String borrowBook(Long bookId);

    String returnBook(Long bookId);
}
