package me.emma.feign;

import me.emma.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("book-service")
public interface BookClient {

    @GetMapping("/books/{id}")
    Book getBookById(@PathVariable Long id);

    @PutMapping("/books/{id}/status")
    String updateBookStatus(@PathVariable Long id, @RequestParam("status") String status);
}
