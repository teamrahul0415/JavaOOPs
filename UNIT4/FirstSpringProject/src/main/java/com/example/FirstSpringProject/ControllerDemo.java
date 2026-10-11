package com.example.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class ControllerDemo {
    @Autowired 
    HelloWorld hw;

    @GetMapping("/gethello")  //http://localhost:8080/gethello
    public String getHelloWorld(){
        return hw.display();
    }

    @GetMapping("/{id}") //http://localhost:8080/gethello/6
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    
}
