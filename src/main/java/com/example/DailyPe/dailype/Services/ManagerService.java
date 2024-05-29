package com.example.DailyPe.dailype.Services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.DailyPe.dailype.Models.Manager;
import com.example.DailyPe.dailype.Repository.ManagerRepository;

@Service
public class ManagerService {
	
	private ManagerRepository managerrepo;
	public ManagerService(ManagerRepository managerrepo) {
		
		this.managerrepo  = managerrepo;
	}
	public Optional<Manager> findById(String managerId) {
		return managerrepo.findById(managerId);
		
	}
}
