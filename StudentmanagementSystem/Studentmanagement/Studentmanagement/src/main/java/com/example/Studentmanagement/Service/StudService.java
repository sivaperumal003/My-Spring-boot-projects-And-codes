package com.example.Studentmanagement.Service;

import com.example.Studentmanagement.Model.Student;
import com.example.Studentmanagement.Repository.StudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudService {
    @Autowired
    StudRepo repo;
    public Student InsertStud(Student stud) {
       return repo.save(stud);
    }

    public List<Student> getStud() {
        return repo.findAll();
    }

    public Student getByid( int id) {
        return repo.findById(id).orElse(null);
    }

    public String Update(int id, Student stud) {
        stud.setId(id);
        repo.save(stud);
        return "Student Updated Successfully ";
    }

    public String DeleteStud() {
        repo.deleteAll();
        return "Record Clear Sucessfully";
    }

    public String DeleteByid(int id) {
        repo.deleteById(id);
        return "Student Delete Successfully";
    }
}
