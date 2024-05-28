package com.example.DailyPe.dailype.Models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Manager {
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID manager_id;
	private String name;
	private String email_id;
	public UUID getManager_id() {
		return manager_id;
	}
	public void setManager_id(UUID manager_id) {
		this.manager_id = manager_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public Manager(UUID manager_id, String name, String email_id) {
		super();
		this.manager_id = manager_id;
		this.name = name;
		this.email_id = email_id;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
