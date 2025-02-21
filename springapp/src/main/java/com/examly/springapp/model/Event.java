package com.examly.springapp.model;
import lombok.*;
import jakarta.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
}
