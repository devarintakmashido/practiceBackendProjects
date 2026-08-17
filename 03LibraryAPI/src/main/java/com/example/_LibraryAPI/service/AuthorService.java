package com.example._LibraryAPI.service;

import com.example._LibraryAPI.dto.AuthorRequest;
import com.example._LibraryAPI.dto.AuthorResponse;
import com.example._LibraryAPI.dto.BookRequest;
import com.example._LibraryAPI.dto.BookResponse;

import com.example._LibraryAPI.entity.Author;
import com.example._LibraryAPI.entity.Book;
import com.example._LibraryAPI.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    // 1. Dependency Injection
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // 1. Update create to return the Response DTO
    public AuthorResponse create(AuthorRequest request) {
        Author author = new Author();
        author.setName(request.getName());

        if (request.getBooks() != null) {
            List<Book> bookEntities = new ArrayList<>();
            for (BookRequest bookReq : request.getBooks()) {
                Book book = new Book();
                book.setTitle(bookReq.getTitle());
                book.setIsbn(bookReq.getIsbn());
                book.setAuthor(author);
                bookEntities.add(book);
            }
            author.setBooks(bookEntities);
        }

        Author savedAuthor = authorRepository.save(author);

        // Use our new helper method below!
        return convertToResponse(savedAuthor);
    }

    // 2. Update findAll to return a List of Response DTOs
// 1. We added the parameters so the Controller can pass the numbers down!
    public List<AuthorResponse> findAll(int page, int size, String sortBy) {

        // 2. We build the "Instruction Manual" for Spring Data JPA
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        // 3. We ask the repository for EXACTLY one page of data
        Page<Author> authorPage = authorRepository.findAll(pageable);

        // 4. We extract the raw list of authors from that page
        List<Author> authors = authorPage.getContent();

        // 5. We loop through them and convert them to DTOs just like before
        List<AuthorResponse> responses = new ArrayList<>();
        for (Author author : authors) {
            responses.add(convertToResponse(author));
        }
        return responses;
    }

    // 3. The Helper Method: Entity -> Response DTO
    private AuthorResponse convertToResponse(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());

        if (author.getBooks() != null) {
            List<BookResponse> bookResponses = new ArrayList<>();
            for (Book book : author.getBooks()) {
                BookResponse bookResp = new BookResponse();
                bookResp.setId(book.getId());
                bookResp.setTitle(book.getTitle());
                bookResp.setIsbn(book.getIsbn());
                bookResponses.add(bookResp);
            }
            response.setBooks(bookResponses);
        }

        return response;
    }

}