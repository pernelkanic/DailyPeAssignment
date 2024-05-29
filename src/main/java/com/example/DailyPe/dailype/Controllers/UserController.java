package com.example.DailyPe.dailype.Controllers;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DailyPe.dailype.DTO.BulkUpdateDTO;
import com.example.DailyPe.dailype.DTO.UserDto;
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
	
	@PostMapping("/create_user")
	public ResponseEntity<?> postUser(@RequestBody UserDto userDto){
		
        if (userDto.getFull_name() == null) {
            return ResponseEntity.badRequest().body("Full name must not be empty");
        }

       
        String mobNum = userDto.getMob_num();
        if (!isValidMobileNumber(mobNum)) {
            return ResponseEntity.badRequest().body("Invalid mobile number format");
        }

        
        mobNum = adjustMobileNumber(mobNum);

       
        String panNum = userDto.getPan_num();
        if (!isValidPANNumber(panNum)) {
            return ResponseEntity.badRequest().body("Invalid PAN number format");
        }
        
    
        userservice.saveUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }
	
	@PutMapping("/update_user")
	public ResponseEntity<?> updateUser(@RequestBody BulkUpdateDTO updateData){
		
		return userservice.updateUser(updateData);
		
		
	}

    
    private boolean isValidMobileNumber(String mobNum) {
        return Pattern.matches("^(0|\\+91)?[1-9]\\d{9}$", mobNum);
    }


    private String adjustMobileNumber(String mobNum) {
        if (mobNum.startsWith("+91")) {
            return mobNum.substring(3);
        } else if (mobNum.startsWith("0")) {
            return mobNum.substring(1);
        }
        return mobNum;
    }

   
    private boolean isValidPANNumber(String panNum) {
        return Pattern.matches("^[A-Z]{5}[0-9]{4}[A-Z]$", panNum);
    }

  
    
}
