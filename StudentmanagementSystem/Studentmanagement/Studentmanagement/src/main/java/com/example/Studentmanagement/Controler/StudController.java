package com.example.Studentmanagement.Controler;

import com.example.Studentmanagement.Model.Student;
import com.example.Studentmanagement.Service.StudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudController {

      @Autowired
      StudService service;

      @PostMapping("add/stud")
      public Student InsertStud(@RequestBody Student stud){
          return service.InsertStud(stud);
      }

      @GetMapping("students")
      public List<Student> GetallStud() {
          return service.getStud();

      }

      @GetMapping("stud/{id}")
     public  Student GetByid(@PathVariable("id") int id){
         return service.getByid(id);
      }

      @PutMapping("/stud/{id}")
    public String Update(@PathVariable int id,@RequestBody Student stud){
          return service.Update(id,stud);
      }

      @DeleteMapping("/clear")
    public String DeleteStud(){

         return service.DeleteStud();
      }

       @DeleteMapping("clear/{id}")
    public String DeleteById(@PathVariable("id") int id){
          return service.DeleteByid(id);
       }

      }


