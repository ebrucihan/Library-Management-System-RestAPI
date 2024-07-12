package com.example.librarymanagement.business.abstracts;

import com.example.librarymanagement.entities.Book;

public interface IBookService {

    Book save(Book book);
    Book get(int id);
    Book update(Book book);
    boolean delete(int id);

}
