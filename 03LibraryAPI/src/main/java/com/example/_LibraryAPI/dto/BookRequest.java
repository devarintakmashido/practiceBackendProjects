package com.example._LibraryAPI.dto;

import jakarta.validation.constraints.NotBlank;

public class BookRequest {

    @NotBlank(message = "Book title is required")
    private String title;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    // Notice what is missing? NO AUTHOR FIELD!
    // The user doesn't need to send the Author inside the Book, because the Book is already inside the AuthorRequest!

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}