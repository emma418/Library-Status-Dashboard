package me.emma.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private Status status;
}
