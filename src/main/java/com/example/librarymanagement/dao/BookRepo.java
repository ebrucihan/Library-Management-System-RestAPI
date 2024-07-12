package com.example.librarymanagement.dao;

import com.example.librarymanagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository <Book, Integer> {
    List<Book> findByCategoriesCategoryId(int categoryId);
}
