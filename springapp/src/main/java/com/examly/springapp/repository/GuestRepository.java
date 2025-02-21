package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {}
