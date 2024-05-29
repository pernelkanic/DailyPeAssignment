package com.example.DailyPe.dailype.DTO;

public class updateDto {
	
	private Integer userId;
	private String mob_num;
	public updateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public updateDto(Integer userId, String mob_num) {
		super();
		this.userId = userId;
		this.mob_num = mob_num;
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMob_num() {
		return mob_num;
	}
	public void setMob_num(String mob_num) {
		this.mob_num = mob_num;
	}
	
}
