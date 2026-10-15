package com.kiet.student.Controller;
import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiet.student.Model.Student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping("/students")
public class StudentController {
    List<Student> users  =new ArrayList<>();

    @PostMapping
    public String postMethodName(@RequestBody Student u) {
        //TODO: process POST request
        users.add(u);
        
        return "Added "+u.getName();
    }

    @GetMapping
    public List<Student> getAllUsers(){
        return users;
    }

    @GetMapping("/{id}")
    public Student getUser(@PathVariable Long id) {
        for(Student u : users){
            if(u.getId().equals(id)){
                return u;
            }
        }
        return null;
      
    }
   
    @DeleteMapping("/{id}")
    public String DeleteUser(@PathVariable Long id) {
        for(Student user : users){
            if(user.getId().equals(id)){
                users.remove(user);
                return "Deleted user"+id;
            }
        }
        return "User not found";
        
      
    }

    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String branch,@RequestParam int year) {

        List<Student> result=new ArrayList<>();

        for(Student s : users){
            if(s.getBranch().equalsIgnoreCase(branch) && s.getYear()==year){
                result.add(s);
            }
        }
        return result;
    }

    @GetMapping("/search")
    public List<Student> getToppers(@RequestParam double cgpa) {

        List<Student> result=new ArrayList<>();

        for(Student s : users){
            if(s.getCgpa()>=cgpa){
                result.add(s);
            }
        }
        return result;
    }


    
    
    
    
}
