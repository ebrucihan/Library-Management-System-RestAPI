package com.example.librarymanagement.business.concretes;

import com.example.librarymanagement.business.abstracts.IBookBorrowingService;
import com.example.librarymanagement.core.exception.NotFoundException;
import com.example.librarymanagement.core.utilies.Msg;
import com.example.librarymanagement.dao.BookBorrowingRepo;
import com.example.librarymanagement.dao.BookRepo;
import com.example.librarymanagement.entities.Book;
import com.example.librarymanagement.entities.BookBorrowing;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowingManager implements IBookBorrowingService {

    private final BookBorrowingRepo bookBorrowingRepo;
    private final BookRepo bookRepo;

    public BookBorrowingManager(BookBorrowingRepo bookBorrowingRepo, BookRepo bookRepo) {
        this.bookBorrowingRepo = bookBorrowingRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        Book book = bookRepo.findById(bookBorrowing.getBook().getBookId())
                .orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        if (book.getBookStock() <= 0) {
            throw new RuntimeException("Kitap stokta yok!");
        }
        book.setBookStock(book.getBookStock() - 1);
        bookRepo.save(book);
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public BookBorrowing get(int id) {
        return this.bookBorrowingRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public boolean delete(int id) {
        BookBorrowing bookBorrowing = this.get(id);
        bookBorrowingRepo.delete(bookBorrowing);
        return true;
    }
}
