package com.example.DailyPe.dailype.DTO;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
		private String full_name;
		private String mob_num;
		private String pan_num;
		private UUID manager_id;
}
