package com.example.AllMappings.Repository;

import com.example.AllMappings.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee,Integer> {
}
