package com.example.DailyPe.dailype.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DailyPe.dailype.Models.Users;
import com.example.DailyPe.dailype.Repository.UserRepository;
@Service
public class UserService {
	private UserRepository userrepository;
	public UserService(UserRepository userrepository) {
		this.userrepository = userrepository;
	}
	
	public List<Users> findAllUser() {
		try {
			
			return userrepository.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		
	}

}
