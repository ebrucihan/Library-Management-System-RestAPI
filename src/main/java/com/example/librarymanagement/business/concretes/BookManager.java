package com.example.librarymanagement.business.concretes;

import com.example.librarymanagement.business.abstracts.IBookService;
import com.example.librarymanagement.core.exception.NotFoundException;
import com.example.librarymanagement.core.utilies.Msg;
import com.example.librarymanagement.dao.BookRepo;
import com.example.librarymanagement.dao.CategoryRepo;
import com.example.librarymanagement.entities.Book;
import com.example.librarymanagement.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class BookManager implements IBookService {

    private final BookRepo bookRepo;
    private final CategoryRepo categoryRepo;

    public BookManager(BookRepo bookRepo, CategoryRepo categoryRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Book save(Book book) {
        Book savedBook = this.bookRepo.save(book);
        // Kategorileri kaydedin
        for (Category category : book.getCategories()) {
            category.getBooks().add(savedBook);
            categoryRepo.save(category);
        }
        return savedBook;
    }

    @Override
    public Book get(int id) {
        return this.bookRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Book update(Book book) {
        Book existingBook = this.bookRepo.findById(book.getBookId())
                .orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));

        if (book.getBorrowings() == null) {
            book.setBorrowings(existingBook.getBorrowings());
        }

        return this.bookRepo.save(book);
    }


    @Override
    public boolean delete(int id) {
        Book book = this.get(id);
        bookRepo.delete(book);
        return true;
    }
}
