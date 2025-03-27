package payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User_UpdateRole_PUT_POJO {

	 private List<UserRole> userRoleList;
	 
	 @Data
	    @NoArgsConstructor
	    @AllArgsConstructor
	    public static class UserRole {
	        private String roleId;
	        private String userRoleStatus;
	    }
	 @JsonIgnore
	    private String endpoint;
}