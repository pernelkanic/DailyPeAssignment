package com.example.DailyPe.dailype.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DailyPe.dailype.Models.Users;
import com.example.DailyPe.dailype.Services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userservice;
	
	@Autowired
	public UserController(UserService userservice ) {
		this.userservice = userservice;
	}
	
	@PostMapping("/get_users")
	public ResponseEntity<?> getAllUser() {
		
			List<Users> users = userservice.findAllUser();
			
			return ResponseEntity.ok(users);
		
		
	}
}
