package com.example._LibraryAPI.repository;

import com.example._LibraryAPI.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
