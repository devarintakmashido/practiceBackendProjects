package com.example._LibraryAPI.controller;

import com.example._LibraryAPI.dto.AuthorResponse;
import com.example._LibraryAPI.entity.User;
import com.example._LibraryAPI.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    // Checkout a book (e.g., POST /api/users/1/checkout/2)
    @PostMapping("/{userId}/checkout/{bookId}")
    public ResponseEntity<String> checkoutBook(@PathVariable Long userId, @PathVariable Long bookId) {
        userService.checkoutBook(userId, bookId);
        return ResponseEntity.ok("Book successfully checked out!");
    }
}