package com.example._LibraryAPI.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // This creates the hidden third table!
    @ManyToMany
    @JoinTable(
            name = "user_books", // Name of the new table
            joinColumns = @JoinColumn(name = "user_id"), // Column for this class (User)
            inverseJoinColumns = @JoinColumn(name = "book_id") // Column for the other class (Book)
    )
    private List<Book> borrowedBooks = new ArrayList<>();

    public User() {}

    public User(Long id, String username, List<Book> borrowedBooks) {
        this.id = id;
        this.username = username;
        this.borrowedBooks = borrowedBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}