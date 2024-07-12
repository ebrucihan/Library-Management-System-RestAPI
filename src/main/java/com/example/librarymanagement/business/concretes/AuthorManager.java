package com.example.librarymanagement.business.concretes;

import com.example.librarymanagement.business.abstracts.IAuthorService;
import com.example.librarymanagement.core.exception.NotFoundException;
import com.example.librarymanagement.core.utilies.Msg;
import com.example.librarymanagement.dao.AuthorRepo;
import com.example.librarymanagement.entities.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorManager implements IAuthorService {

    private final AuthorRepo authorRepo;

    public AuthorManager(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public Author get(int id) {
        return this.authorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Author update(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public boolean delete(int id) {
        Author author = this.get(id);
        this.authorRepo.delete(author);
        return true;
    }



}
