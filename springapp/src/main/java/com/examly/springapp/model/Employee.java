package com.examly.springapp.model;
import lombok.*;
import jakarta.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String employeeName;
    
    private String designation;

}
