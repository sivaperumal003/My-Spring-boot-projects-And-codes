package com.example.AllMappings.Controller;

import com.example.AllMappings.Model.Employee;
import com.example.AllMappings.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpService service;

    @PostMapping("Employee")
    public String InsertEmp(@RequestBody Employee emp){
        return service.InsertEmp(emp);
    }

    @GetMapping("Employee")
    public List<Employee> getEmp(){
        return service.getEmp();
    }

    @PutMapping("Employee/{id}")
    public  String UpdateEmp(@PathVariable("id") int id,@RequestBody Employee emp){
        return service.UpdateEmp(id,emp);
    }

    @DeleteMapping("Employee")
    public String DeleteEmp(){
        return service.DeleteEmp();
    }
}
