package com.example.OneToOne.Service;

import com.example.OneToOne.Model.Address;
import com.example.OneToOne.Model.Courses;
import com.example.OneToOne.Model.Department;
import com.example.OneToOne.Model.Employee;
import com.example.OneToOne.Repository.CourseRepo;
import com.example.OneToOne.Repository.DepartRepo;
import com.example.OneToOne.Repository.EmpRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    EmpRepo Erepo;

    @Autowired
    DepartRepo Drepo;

    @Autowired
    CourseRepo Crepo;

    public List<Employee> getEmp() {
        return  Erepo.findAll();
    }

    public Employee getEmpById(int id) {
        return Erepo.findById(id).orElse(null);
    }

    public String UpdateEmp( int id,Employee emp) {
        emp.setId(id);
        Optional<Employee> emopt=Erepo.findById(id);
         if(!emopt.isPresent()){
             throw new EntityNotFoundException("E,ployee with "+id+"Not present");
         }
         Employee Exist=emopt.get();

         if(emp.getName()==null){
             emp.setName(Exist.getName());
         }
         if(emp.getAddress()==null){
             emp.setAddress(Exist.getAddress());
         }else{
             Address add=emp.getAddress();

             if (Exist.getAddress() != null) {
                 add.setId(Exist.getAddress().getId());
             }

             emp.setAddress(add);
         }

        Erepo.save(emp);
        return "Employee Updated SuccessFully";

    }

    public String InsertEmp(Employee emp) {
        if(emp.getDepartment()!=null) {
            Department exist = Drepo.findByDept(emp.getDepartment().getDept());
            if(exist!=null){
                emp.setDepartment(exist);
            }
        }

        if(emp.getCourses().size()>0){
            List<Courses> newCourse=new ArrayList<>();
            for(Courses course : emp.getCourses()){
                Courses existCourse= Crepo.findByName(course.getName());
                if(existCourse!=null){
                    newCourse.add(existCourse);
                }else {
                    newCourse.add(course);
                }
                emp.setCourses(newCourse);
            }
        }



        Erepo.save(emp);
        return "Insert SuccessFully";
    }

    public String DeleteEmp() {
        Erepo.deleteAll();
        return "Deleted All records Sucess fully";

    }
}
