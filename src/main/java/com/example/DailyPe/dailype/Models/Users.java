package com.example.DailyPe.dailype.Models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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

		@Column(updatable = false)
	    @CreationTimestamp
	    private LocalDateTime createdAt;
	    @UpdateTimestamp
	    private LocalDateTime updatedAt;
	    
	    
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
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Users(UUID manager_id, String full_name, String pan_num, String mob_num, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.manager_id = manager_id;
		this.full_name = full_name;
		this.pan_num = pan_num;
		this.mob_num = mob_num;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
