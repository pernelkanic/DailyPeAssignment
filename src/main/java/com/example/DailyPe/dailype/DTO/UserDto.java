package com.example.DailyPe.dailype.DTO;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class UserDto {
		private String full_name;
		private String mob_num;
		private String pan_num;
		private String manager_id;
		public String getFull_name() {
			return full_name;
		}
		public void setFull_name(String full_name) {
			this.full_name = full_name;
		}
		public String getMob_num() {
			return mob_num;
		}
		public void setMob_num(String mob_num) {
			this.mob_num = mob_num;
		}
		public String getPan_num() {
			return pan_num;
		}
		public void setPan_num(String pan_num) {
			this.pan_num = pan_num;
		}
		public String getManager_id() {
			return manager_id;
		}
		public void setManager_id(String manager_id) {
			this.manager_id = manager_id;
		}
		public UserDto(String full_name, String mob_num, String pan_num, String manager_id) {
			super();
			this.full_name = full_name;
			this.mob_num = mob_num;
			this.pan_num = pan_num;
			this.manager_id = manager_id;
		}
		public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
