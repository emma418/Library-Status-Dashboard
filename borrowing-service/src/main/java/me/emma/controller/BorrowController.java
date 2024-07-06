package me.emma.controller;

import lombok.AllArgsConstructor;
import me.emma.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BorrowController {
    private final BorrowService borrowService;

    @PostMapping("/borrow/{bookId}")
    public String borrowBook(@PathVariable Long bookId) {
        return borrowService.borrowBook(bookId);
    }

    @PostMapping("/return/{bookId}")
    public String returnBook(@PathVariable Long bookId) {
        return borrowService.returnBook(bookId);
    }



}
