package com.example.DailyPe.dailype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.DailyPe.dailype.Models.Users;
@Repository	
public interface UserRepository extends	 JpaRepository<Users , Integer>{
	 @Query("SELECT u FROM Users u WHERE u.mob_num = :mob_num")
	Optional<Users> findByMob_num(String mob_num);

}
