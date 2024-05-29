package com.example.DailyPe.dailype.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.DailyPe.dailype.DTO.BulkUpdateDTO;
import com.example.DailyPe.dailype.DTO.UserDto;
import com.example.DailyPe.dailype.Models.Manager;
import com.example.DailyPe.dailype.Models.Users;
import com.example.DailyPe.dailype.Repository.ManagerRepository;
import com.example.DailyPe.dailype.Repository.UserRepository;

@Service
public class UserService {
	private UserRepository userrepository;
	private ManagerService managerservice;
	private ManagerRepository managerrepo;
	public UserService(UserRepository userrepository , ManagerService managerservice , ManagerRepository managerrepo) {
		this.userrepository = userrepository;
		this.managerservice  = managerservice;
		this.managerrepo =  managerrepo;
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
			String managerId = userdto.getManager_id();
			 
			   if (managerId != null) {
				  Optional<Manager> optionalManager = managerservice.findById(managerId);
			   
				   if (optionalManager.isPresent()) {
	             
					   Manager manager = optionalManager.get();
	                
	                
					   
	            } else {
	             
	                throw new IllegalArgumentException("Manager not found with ID: " + managerId);
	            }
				   
				 
		}
			   userrepository.save(user);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ;
		}
	

}
	public ResponseEntity<?> updateUser(BulkUpdateDTO updateData){
		
		List<Integer>userId = updateData.getUserIds();
		UserDto updateobj = updateData.getUpdateData();
		//do a bulk update if manager id is there 
		if(updateobj.getManager_id() != null && userId.size() >= 1) {
			for(Integer userid : userId ) {
				Optional<Users> optionalUser = userrepository.findById(userid);
				if(optionalUser.isPresent()) {
					Users updateuser = optionalUser.get();
					String managerId = updateData.getUpdateData().getManager_id();
					helperUpdate(updateuser , managerId);
					
				}
				else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: User with ID " + userId + " not found.");
				}
			}
		}
		else if(userId.size() > 1){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bulk Update is applicable only for manager_ids");
		}
		else {
			List<Integer> userid = updateData.getUserIds();
			Integer singleuserid = userid.get(0);
			UserDto userupdate = updateData.getUpdateData();
			Optional<Users> user = userrepository.findById(singleuserid);
			if(user.isPresent()) {
				Users updateuser = user.get();
				if(userupdate.getFull_name() != null)
				updateuser.setFull_name(userupdate.getFull_name());
				if(userupdate.getMob_num() != null)
				updateuser.setMob_num(userupdate.getMob_num());
				if(userupdate.getPan_num() != null)
				updateuser.setPan_num(userupdate.getPan_num());
				
				updateuser.setUpdatedAt(LocalDateTime.now());
				
				userrepository.save(updateuser);
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error:User id is not found ");
			}
			
		}
		 return ResponseEntity.ok("Normal update successful.");
		
	}
	//helper for update
	public void helperUpdate(Users updateuser, String managerId) {
		Optional<Manager> managers = managerrepo.findById(managerId);
		if(managers.isPresent()) {
			Manager manager = managers.get();
			if( updateuser.getManager() != null && updateuser.getManager().getManager_id().equals(managerId)) {
				return;
			}
			LocalDateTime now = LocalDateTime.now();
			if( updateuser.getManager() != null ) {
				updateuser.setIs_active(false);
				userrepository.save(updateuser);
			}
			
			updateuser.setFull_name(updateuser.getFull_name());
			updateuser.setMob_num(updateuser.getMob_num());
			updateuser.setManager(manager);
			updateuser.setUpdatedAt(now);
			updateuser.setPan_num(updateuser.getPan_num());
			userrepository.save(updateuser);
		}
	}
}
