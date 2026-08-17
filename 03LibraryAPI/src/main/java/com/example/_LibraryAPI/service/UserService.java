package com.example._LibraryAPI.service;

import com.example._LibraryAPI.entity.Book;
import com.example._LibraryAPI.entity.User;
import com.example._LibraryAPI.repository.BookRepository;
import com.example._LibraryAPI.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UserService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    // 1. A simple method to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 2. THE CHECKOUT LOGIC
    public void checkoutBook(Long userId, Long bookId) {
        // Find the user (or crash if they don't exist)
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Find the book (or crash if it doesn't exist)
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // THE MAGIC LINE: Just add the book to the user's list!
        user.getBorrowedBooks().add(book);

        // Save the user. Spring will automatically insert a row into the user_books join table!
        userRepository.save(user);
    }

}