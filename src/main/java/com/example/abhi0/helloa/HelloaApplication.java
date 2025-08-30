package com.example.abhi0.helloa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloaApplication.class, args);
	}


	// Bidirectional Relationships--onetomany,manytoone,manytomany
	
	// unidirectional mtlb book ka author nikal sakte but author se book nahi toh yeh bi me hoga
    // assume parent as book and child as author 
	// @JsonManagedReference- parent pr
	// @JsonBackReference-  child pr


}
