package com.example.DailyPe.dailype.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DailyPe.dailype.Models.Users;
@Repository	
public interface UserRepository extends	 JpaRepository<Users , UUID>{

}
