package com.example.FirstSpringProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController 
@RequestMapping("/students")
public class restcontrollerdemo {
    @GetMapping("{/id}")  //http://localhost:8080/stundets/1000 on GET API
    public String getMethodName(@RequestParam String id) {
        return "User"+id;
    }

    @PostMapping  //http://localhost:8080/stundets on POST API
    public String postMethodName(@RequestBody String user) {
        //TODO: process POST request
        
        return "Created"+user;
    }

    @PutMapping("/{id}")  //http://localhost:8080/stundets/5 on PUT API
    public String putMethodName(@PathVariable String id, @RequestBody String user) {
        //TODO: process PUT request
        
        return "Updated"+user;
    }

    @DeleteMapping("/{id}")  //http://localhost:8080/stundets/6 on DELETE API
    public String deleteUser(@PathVariable Long id){
        return "Deleted+id";
    }
    
    
    
}

// package com.example.FirstSpringProject;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;

// @RestController
// public class restcontrollerdemo{

//     @Autowired
//     HelloWorld hw;

//     @GetMapping("/gethello")
//     public String getHelloWorld() {
//         return hw.display();
//     }

//     // Example: http://localhost:8080/6
//     @GetMapping("/{id}")
//     public String getMethodName(@PathVariable String id) {
//         return "ID is: " + id;
//     }

//     // Example: http://localhost:8080/student?id=6
//     @GetMapping("/student")
//     public String getStudent(@RequestParam String id) {
//         return "Student ID is: " + id;
//     }
// }


