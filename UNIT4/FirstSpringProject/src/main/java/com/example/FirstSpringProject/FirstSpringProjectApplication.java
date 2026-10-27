package com.example.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringProjectApplication implements CommandLineRunner{
	@Autowired 
	HelloWorld hw;

	public static void main(String[] args) {
		//it return applicationcontext
		ApplicationContext context=SpringApplication.run(FirstSpringProjectApplication.class, args);
		System.out.println(context.getBeanDefinitionCount());

		String[] names=context.getBeanDefinitionNames();

		for(int i=0;i<names.length;i++){
			System.out.println(i+1+" "+names[i]);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		hw.display();
		
	}

}
