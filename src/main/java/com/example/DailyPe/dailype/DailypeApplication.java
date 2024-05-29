package com.example.DailyPe.dailype;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.DailyPe.dailype.Models.Manager;
import com.example.DailyPe.dailype.Repository.ManagerRepository;

@SpringBootApplication
public class DailypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailypeApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner loadData(ManagerRepository repository) {
//	    return (args) -> {
//	        
//	        repository.save(new Manager(UUID.randomUUID().toString(), "Jack", "Bauer"));
//	        repository.save(new Manager(UUID.randomUUID().toString(),"Chloe", "O'Brian"));
//	        repository.save(new Manager(UUID.randomUUID().toString() ,"Kim", "Bauer"));
//	        repository.save(new Manager(UUID.randomUUID().toString(), "David", "Palmer"));
//	        repository.save(new Manager(UUID.randomUUID().toString(),"Michelle", "Dessler"));	
//	    };
//	}
}
