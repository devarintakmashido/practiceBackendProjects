package com.example._LibraryAPI.dto;

public class BookResponse {
    private Long id;
    private String title;
    private String isbn;

    // Notice: No Author field here! The loop is broken forever.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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