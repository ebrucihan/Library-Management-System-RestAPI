package com.example.librarymanagement.dao;

import com.example.librarymanagement.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowingRepo extends JpaRepository<BookBorrowing,Integer> {
}
