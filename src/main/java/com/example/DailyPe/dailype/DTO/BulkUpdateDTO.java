package com.example.DailyPe.dailype.DTO;

import java.util.List;
import java.util.UUID;

public class BulkUpdateDTO {
	 private List<Integer> userIds;
	    private UserDto updateData;

	  
	    public BulkUpdateDTO(List<Integer> userIds, UserDto updateData) {
	        this.userIds = userIds;
	        this.updateData = updateData;
	    }

	    public List<Integer> getUserIds() {
	        return userIds;
	    }

	    public void setUserIds(List<Integer> userIds) {
	        this.userIds = userIds;
	    }

	    public UserDto getUpdateData() {
	        return updateData;
	    }

	    public void setUpdateData(UserDto updateData) {
	        this.updateData = updateData;
	    }
}
