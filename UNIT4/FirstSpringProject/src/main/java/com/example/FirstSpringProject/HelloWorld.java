package com.example.FirstSpringProject;

import org.slf4j.*;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component 
public class HelloWorld {
public static final Logger logger = LoggerFactory.getLogger(HelloWorld.class); 
    
    public String display(){
        logger.info("Hello World!");
        return "Hello World";
    }
}
