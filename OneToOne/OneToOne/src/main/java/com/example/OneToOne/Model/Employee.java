package com.example.OneToOne.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;

    @OneToOne(cascade =CascadeType.ALL)
    @JsonManagedReference
    Address address;

    @OneToMany(cascade = CascadeType.ALL)
    List<Project> project;

    @ManyToOne(cascade = CascadeType.ALL)
    Department department;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Courses> courses;


}
