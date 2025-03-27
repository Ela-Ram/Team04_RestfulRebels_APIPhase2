package payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import payload.User_POJO.UserLogin;
import payload.User_POJO.UserRoleMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_PUT_POJO {
	
	private String userComments;
    private String userEduPg;
    private String userEduUg;
    private String userFirstName;
    private String userLastName;
    private String userLinkedinUrl;
    private String userLocation;
    private String userMiddleName;
    private String userLoginEmail;
    private String userId;
    private String userPhoneNumber;
    private String userTimeZone;
    private String userVisaStatus;

    
   /* @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserLogin {
        private String loginStatus;
        private String userLoginEmail;
    }*/
    
    @JsonIgnore
    private String endpoint;
}
