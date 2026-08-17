package com.example._LibraryAPI.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class AuthorRequest {

    // The user MUST provide a name, otherwise Spring automatically rejects it with a 400 Bad Request!
    @NotBlank(message = "Author name cannot be empty")
    private String name;

    // For now, we will just accept a list of Book Request objects (we'll make this next)
    private List<BookRequest> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookRequest> getBooks() {
        return books;
    }

    public void setBooks(List<BookRequest> books) {
        this.books = books;
    }
}