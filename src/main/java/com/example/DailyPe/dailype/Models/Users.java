package com.example.DailyPe.dailype.Models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID  manager_id;
	private String full_name;
	private String pan_num;
	private String mob_num;
	public UUID getManager_id() {
		return manager_id;
	}
	public void setManager_id(UUID manager_id) {
		this.manager_id = manager_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getPan_num() {
		return pan_num;
	}
	public void setPan_num(String pan_num) {
		this.pan_num = pan_num;
	}
	public String getMob_num() {
		return mob_num;
	}
	public void setMob_num(String mob_num) {
		this.mob_num = mob_num;
	}
	public Users(UUID manager_id, String full_name, String pan_num, String mob_num) {
		super();
		this.manager_id = manager_id;
		this.full_name = full_name;
		this.pan_num = pan_num;
		this.mob_num = mob_num;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
