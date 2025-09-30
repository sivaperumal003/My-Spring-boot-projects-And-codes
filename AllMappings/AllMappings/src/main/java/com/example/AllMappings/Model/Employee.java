package com.example.AllMappings.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
     @JsonManagedReference
    Address address;

    @OneToMany(cascade = CascadeType.ALL)
    List<Projects> project;

    @ManyToOne(cascade = CascadeType.ALL)
    Department department;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Courses> course;

}
