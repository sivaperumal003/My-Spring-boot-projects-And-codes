package com.example.OneToOne.Repository;

import com.example.OneToOne.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartRepo extends JpaRepository<Department,Integer> {

    public Department findByDept(String dept);
}
