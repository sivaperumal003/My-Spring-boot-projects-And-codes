package com.example.OneToOne.Repository;

import com.example.OneToOne.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses,Integer> {
    Courses findByName(String name);

}
