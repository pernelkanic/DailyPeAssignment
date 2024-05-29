package com.example.DailyPe.dailype.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserId;
	private String full_name;
	private String pan_num;
	private String mob_num;
    @ManyToOne
    private Manager manager;
	
		@Column(updatable = false)
	    @CreationTimestamp
	    private LocalDateTime createdAt;
	    @UpdateTimestamp
	    private LocalDateTime updatedAt;
	    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
	    private boolean is_active = true;
	    
		public Manager getManager() {
			return manager;
		}
		public void setManager(Manager manager) {
			this.manager = manager;
		}
		public boolean isIs_active() {
			return is_active;
		}
		public void setIs_active(boolean is_active) {
			this.is_active = is_active;
		}
		public Integer getUserId() {
			return UserId;
		}
		public void setUserId(Integer userId) {
			UserId = userId;
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


	public Users(Integer userId, String full_name, String pan_num, String mob_num, Manager manager,
			LocalDateTime createdAt, LocalDateTime updatedAt, boolean is_active) {
		super();
		UserId = userId;
		this.full_name = full_name;
		this.pan_num = pan_num;
		this.mob_num = mob_num;
		this.manager = manager;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.is_active = is_active;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
