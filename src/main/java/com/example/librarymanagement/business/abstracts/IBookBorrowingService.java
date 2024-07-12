package com.example.librarymanagement.business.abstracts;

import com.example.librarymanagement.entities.BookBorrowing;

public interface IBookBorrowingService {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing get(int id);
    BookBorrowing update(BookBorrowing bookBorrowing);
    boolean delete(int id);
}
