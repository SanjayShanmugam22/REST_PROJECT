package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {}
