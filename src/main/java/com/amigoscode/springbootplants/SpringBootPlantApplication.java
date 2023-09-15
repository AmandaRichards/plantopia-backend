package com.amigoscode.springbootplants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController // exposes functions with get post put mappings as endpoints clients can call. Method in marked class return json response
@CrossOrigin
@RequestMapping("api/v1/plants") //setting api end point at the root
public class SpringBootPlantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPlantApplication.class, args);
	}


//
}

