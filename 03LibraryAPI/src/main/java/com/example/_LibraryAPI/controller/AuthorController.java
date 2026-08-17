package com.example._LibraryAPI.controller;

import com.example._LibraryAPI.dto.AuthorRequest;
import com.example._LibraryAPI.dto.AuthorResponse;
import com.example._LibraryAPI.entity.Author;
import com.example._LibraryAPI.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    // Changed to private!
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Changed to @PostMapping and renamed to createAuthor
    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@Valid @RequestBody AuthorRequest request) {
        AuthorResponse savedAuthor = authorService.create(request);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAuthors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        // Pass the parameters down to the Service layer!
        List<AuthorResponse> authors = authorService.findAll(page, size, sortBy);

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}