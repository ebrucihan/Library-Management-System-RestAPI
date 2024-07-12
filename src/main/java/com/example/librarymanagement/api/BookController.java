package com.example.librarymanagement.api;


import com.example.librarymanagement.business.abstracts.IBookService;
import com.example.librarymanagement.business.abstracts.ICategoryService;
import com.example.librarymanagement.core.config.ModelMapper.IModelMapperService;
import com.example.librarymanagement.core.result.Result;
import com.example.librarymanagement.core.result.ResultData;
import com.example.librarymanagement.core.utilies.ResultHelper;
import com.example.librarymanagement.dto.request.book.BookSaveRequest;
import com.example.librarymanagement.dto.request.book.BookUpdateRequest;
import com.example.librarymanagement.dto.response.book.BookResponse;
import com.example.librarymanagement.entities.Book;
import com.example.librarymanagement.entities.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v2/books")
public class BookController {

    private final IBookService bookService;
    private final ICategoryService categoryService; // Add the categoryService
    private final IModelMapperService modelMapper;

    public BookController(IBookService bookService, ICategoryService categoryService, IModelMapperService modelMapper) {
        this.bookService = bookService;
        this.categoryService = categoryService; // Initialize the categoryService
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest) {
        Book saveBook = this.modelMapper.forRequest().map(bookSaveRequest, Book.class);
        this.bookService.save(saveBook);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBook, BookResponse.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) {
        Book updateBook = this.modelMapper.forRequest().map(bookUpdateRequest, Book.class);
        List<Category> categories = bookUpdateRequest.getCategoryIds().stream()
                .map(categoryService::get)
                .collect(Collectors.toList());
        updateBook.setCategories(categories);
        this.bookService.update(updateBook);
        BookResponse bookResponse = this.modelMapper.forResponse().map(updateBook, BookResponse.class);
        return ResultHelper.success(bookResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> get(@PathVariable("id") int id) {
        Book book = this.bookService.get(id);
        BookResponse bookResponse = this.modelMapper.forResponse().map(book, BookResponse.class);
        return ResultHelper.success(bookResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.bookService.delete(id);
        return ResultHelper.ok();
    }
}