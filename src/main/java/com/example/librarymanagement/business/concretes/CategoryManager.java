package com.example.librarymanagement.business.concretes;

import com.example.librarymanagement.business.abstracts.ICategoryService;
import com.example.librarymanagement.core.exception.NotFoundException;
import com.example.librarymanagement.core.utilies.Msg;
import com.example.librarymanagement.dao.BookRepo;
import com.example.librarymanagement.dao.CategoryRepo;
import com.example.librarymanagement.entities.Book;
import com.example.librarymanagement.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepo categoryRepo;
    private final BookRepo bookRepo;

    public CategoryManager(CategoryRepo categoryRepo, BookRepo bookRepo) {
        this.categoryRepo = categoryRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(int id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Category update(Category category) {
        this.get(category.getCategoryId());
        return this.categoryRepo.save(category);
    }

    @Override
    public String delete(int id) {
        List<Book> books = bookRepo.findByCategoriesCategoryId(id);
        if (!books.isEmpty()) {
            return "Bu kategoriye ait kitap var. Bu kategori silinemedi.";
        }
        Category category = this.get(id);
        this.categoryRepo.delete(category);
        return "Kategori silindi.";
    }
}
