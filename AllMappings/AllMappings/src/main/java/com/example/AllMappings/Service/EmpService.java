package com.example.AllMappings.Service;

import com.example.AllMappings.Model.Address;
import com.example.AllMappings.Model.Courses;
import com.example.AllMappings.Model.Department;
import com.example.AllMappings.Model.Employee;
import com.example.AllMappings.Repository.AddressRepo;
import com.example.AllMappings.Repository.CourseRepo;
import com.example.AllMappings.Repository.DepartmentRepo;
import com.example.AllMappings.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpRepo Erepo;

    @Autowired
    AddressRepo Arepo;

    @Autowired
    DepartmentRepo Drepo;

    @Autowired
    CourseRepo Crepo;

    public String InsertEmp(Employee emp) {
        if(emp.getAddress()!=null){
            Address newAddress = new Address();
            newAddress.setCity(emp.getAddress().getCity());
            emp.setAddress(newAddress);
        }


        if(emp.getDepartment()!=null){
            Department existDept=Drepo.findByName(emp.getDepartment().getName());
            if(existDept!=null){
                emp.setDepartment(existDept);
            }
        }

        if(emp.getCourse().size()>0){
            List<Courses> newCourse=new ArrayList<>();
            for(Courses course : emp.getCourse()){
                Courses existcourse= Crepo.findByName(course.getName());
                if(existcourse!=null){
                    newCourse.add(existcourse);
                }else{
                    newCourse.add(course);
                }
            }
            emp.setCourse(newCourse);
        }
        Erepo.save(emp);
        return "Inserted Successfully";

    }

    public List<Employee> getEmp() {
        return Erepo.findAll();
    }

    public String UpdateEmp(int id, Employee emp) {
        emp.setId(id);
        Erepo.save(emp);
        return "Sucessfully Updated...";
    }

    public String DeleteEmp() {
        Erepo.deleteAll();
        return "Deleted SucesssFully...";
    }
}
