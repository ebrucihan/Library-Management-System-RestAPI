package com.example.librarymanagement.business.abstracts;

import com.example.librarymanagement.entities.Publisher;

public interface IPublisherService {

    Publisher save(Publisher publisher);
    Publisher get(int id);
    Publisher update(Publisher publisher);
    boolean delete(int id);
}
