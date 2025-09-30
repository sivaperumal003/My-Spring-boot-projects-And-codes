package com.example.AllMappings.Repository;

import com.example.AllMappings.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses,Integer> {
    Courses findByName(String name);
}
