package com.example.DailyPe.dailype.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.DailyPe.dailype.DTO.UserDto;
import com.example.DailyPe.dailype.Models.Manager;
import com.example.DailyPe.dailype.Models.Users;
import com.example.DailyPe.dailype.Repository.UserRepository;
@Service
public class UserService {
	private UserRepository userrepository;
	private ManagerService managerservice;
	public UserService(UserRepository userrepository , ManagerService managerservice) {
		this.userrepository = userrepository;
		this.managerservice  = managerservice;
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
	public void saveUser(UserDto userdto) {
		try {
			Users user = new Users();
			user.setFull_name(userdto.getFull_name());
			user.setMob_num(userdto.getMob_num());
			user.setPan_num(userdto.getPan_num().toUpperCase());
			 UUID managerId = userdto.getManager_id();
			 
			   if (managerId != null) {
				  Optional<Manager> optionalManager = managerservice.findById(managerId);
			   
				   if (optionalManager.isPresent()) {
	             
					   Manager manager = optionalManager.get();
	                
	                
	                user.setManager(manager);
	            } else {
	             
	                throw new IllegalArgumentException("Manager not found with ID: " + managerId);
	            }
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			return ;
		}
	

}
}
