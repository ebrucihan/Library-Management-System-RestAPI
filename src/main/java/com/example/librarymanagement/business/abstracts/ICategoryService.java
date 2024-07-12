package com.example.librarymanagement.business.abstracts;

import com.example.librarymanagement.entities.Category;

public interface ICategoryService {

    Category save(Category category);
    Category get(int id);
    Category update(Category category);
    String delete(int id);
}
