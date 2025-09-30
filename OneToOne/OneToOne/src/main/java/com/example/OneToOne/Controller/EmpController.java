package com.example.OneToOne.Controller;

import com.example.OneToOne.Model.Employee;
import com.example.OneToOne.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
     EmpService Eservice;

    @GetMapping("Employee")
    public List<Employee> getEmp(){
        return Eservice.getEmp();
    }
    @GetMapping("Employee/{id}")
    public Employee getEmpById(@PathVariable("id") int id){

        return Eservice.getEmpById(id);

    }
    @PutMapping("Employee/{id}")
    public String UpdateEmp(@PathVariable("id") int id, @RequestBody Employee emp){
        return Eservice.UpdateEmp(id,emp);

    }

    @PostMapping("Employee")
    public String InsertEmp(@RequestBody Employee emp){
        return Eservice.InsertEmp(emp);
    }

    @DeleteMapping("Employee")
    public String DeleteEmp(){
        return Eservice.DeleteEmp();

    }
}
