package com.examly.springapp.service;

import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository repository;

    public List<Guest> getAll() {
        return repository.findAll();
    }

    public Guest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Guest save(Guest guest) {
        return repository.save(guest);
    }

    public Guest update(Long id, Guest updatedGuest) {
        if (repository.existsById(id)) {
            updatedGuest.setId(id);
            return repository.save(updatedGuest);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
