package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_POJO {

	private String userComments;
    private String userEduPg;
    private String userEduUg;
    private String userFirstName;
    private String userLastName;
    private String userLinkedinUrl;
    private String userLocation;
    private String userMiddleName;
    private String userPhoneNumber;
    private List<UserRoleMap> userRoleMaps;
    private String userTimeZone;
    private String userVisaStatus;
    private UserLogin userLogin;
    

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserRoleMap {
        private String roleId;
        private String userRoleStatus;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserLogin {
        private String loginStatus;
        private String userLoginEmail;
    }
    
    @JsonIgnore
    private String endpoint;
}