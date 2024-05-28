package com.example.DailyPe.dailype.Models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;

	
	@ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
    private Manager  manager;
	private String full_name;
	private String pan_num;
	private String mob_num;

		@Column(updatable = false)
	    @CreationTimestamp
	    private LocalDateTime createdAt;
	    @UpdateTimestamp
	    private LocalDateTime updatedAt;
	    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
	    private boolean is_active;
	    

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

	public Users(Integer user_id, Manager  manager, String full_name, String pan_num, String mob_num,
			LocalDateTime createdAt, LocalDateTime updatedAt, boolean is_active) {
		super();
		this.user_id = user_id;
		this.manager = manager;
		this.full_name = full_name;
		this.pan_num = pan_num;
		this.mob_num = mob_num;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.is_active = is_active;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Manager  getManager() {
		return manager;
	}
	public void setManager(Manager  manager) {
		this.manager = manager;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
