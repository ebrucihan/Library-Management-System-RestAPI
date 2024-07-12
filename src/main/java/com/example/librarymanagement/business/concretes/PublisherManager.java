package com.example.librarymanagement.business.concretes;

import com.example.librarymanagement.business.abstracts.IPublisherService;
import com.example.librarymanagement.core.exception.NotFoundException;
import com.example.librarymanagement.core.utilies.Msg;
import com.example.librarymanagement.dao.PublisherRepo;
import com.example.librarymanagement.entities.Publisher;
import org.springframework.stereotype.Service;

@Service
public class PublisherManager implements IPublisherService {

    private final PublisherRepo publisherRepo;

    public PublisherManager(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public Publisher get(int id) {
        return this.publisherRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Publisher update(Publisher publisher) {
        Publisher existingPublisher = this.get(publisher.getPublisherId());
        existingPublisher.setPublisherName(publisher.getPublisherName());
        existingPublisher.setPublisherEstablishmentYear(publisher.getPublisherEstablishmentYear());
        existingPublisher.setAddress(publisher.getAddress());
        existingPublisher.setBooks(publisher.getBooks());
        return this.publisherRepo.save(existingPublisher);
    }

    @Override
    public boolean delete(int id) {
        Publisher publisher = this.get(id);
        this.publisherRepo.delete(publisher);
        return true;
    }
}
