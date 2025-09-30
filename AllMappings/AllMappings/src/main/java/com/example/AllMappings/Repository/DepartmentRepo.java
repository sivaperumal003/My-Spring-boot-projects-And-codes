package com.example.AllMappings.Repository;

import com.example.AllMappings.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    Department findByName(String name);
}
