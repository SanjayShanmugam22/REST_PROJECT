package com.examly.springapp.controller;

import com.examly.springapp.model.Guest;
import com.examly.springapp.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {
    @Autowired
    private GuestService service;

    @GetMapping
    public List<Guest> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Guest getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Guest create(@RequestBody Guest guest) {
        return service.save(guest);
    }

    @PutMapping("/{id}")
    public Guest update(@PathVariable Long id, @RequestBody Guest guest) {
        return service.update(id, guest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
