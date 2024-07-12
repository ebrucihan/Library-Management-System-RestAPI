package com.example.librarymanagement.business.abstracts;

import com.example.librarymanagement.entities.Author;

public interface IAuthorService {
    Author save(Author author);
    Author get(int id);
    Author update(Author author);
    boolean delete(int id);
}
