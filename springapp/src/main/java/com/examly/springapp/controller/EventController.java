package com.examly.springapp.controller;

import com.examly.springapp.model.Event;
import com.examly.springapp.service.EventService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<Event>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<Event> events = service.getAll(page, size);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Event> geteventd() 
    {
            return null;
        // return (List<Event>) service.getallevent();
    }
    

    @PostMapping
    public Event create(@RequestBody Event event) {
        return service.save(event);
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event event) {
        return service.update(id, event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
