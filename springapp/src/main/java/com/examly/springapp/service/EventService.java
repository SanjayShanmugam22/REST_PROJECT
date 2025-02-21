package com.examly.springapp.service;

import com.examly.springapp.model.Event;
import com.examly.springapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
//import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    public Page<Event> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Event getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Event getallevent()
    {
        return (Event) repository.findAll();
    }
    public Event save(Event event) {
        return repository.save(event);
    }

    public Event update(Long id, Event updatedEvent) {
        if (repository.existsById(id)) {
            updatedEvent.setId(id);
            return repository.save(updatedEvent);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
