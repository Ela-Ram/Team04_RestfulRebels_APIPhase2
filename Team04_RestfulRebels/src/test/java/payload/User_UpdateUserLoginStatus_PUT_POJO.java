package payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import payload.User_UpdateRole_PUT_POJO.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_UpdateUserLoginStatus_PUT_POJO {

	private String loginStatus;
	//private String password;
	//private String roleIds;
	private String status;
	private String userLoginEmail;
	
	 @JsonIgnore
	    private String endpoint;
}