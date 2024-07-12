package com.example.librarymanagement.dao;

import com.example.librarymanagement.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
