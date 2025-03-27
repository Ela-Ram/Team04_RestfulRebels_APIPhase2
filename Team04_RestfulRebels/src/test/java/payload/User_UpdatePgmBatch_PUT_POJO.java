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

public class User_UpdatePgmBatch_PUT_POJO {

	private int programId;
	private String roleId;
	private String userId;
	private List<UserRoleProgramBatches> userRoleProgramBatches;
	
	 	@Data
	    @NoArgsConstructor
	    @AllArgsConstructor
	    public static class UserRoleProgramBatches {
	     private int batchId;
	     private String userRoleProgramBatchStatus;
	 }
	
	 @JsonIgnore
	    private String endpoint;
}