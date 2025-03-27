package enumPackage;

public enum Endpoint {
    Login_POST("/login"),
    Logout_Get("/logoutlms"),
    Program_POST("/saveprogram"),
    Program_GET_allPrograms("/allPrograms"),
    Program_GET_allProgram_withUsers("/allProgramsWithUsers"),
     Program_GET_ProgramId("/programs/"),
     Program_PUT_byProgramName("/program/"),
     Program_PUT_byProgramId("/putprogram/"),
    Program_DELETE_byProgramId("/deletebyprogid/"),
    Program_DELETE_byProgramName("/deletebyprogname/"),
    Batch_POST("/batches"),
     Batch_GET_allBatches("/batches"),
     Batch_GET_BatchByBatchName("/batches/batchName/"),
     Batch_GET_byBatchId("/batches/batchId/"),
      Batch_GET_byProgramId("/batches/program/"),        
      Batch_PUT_byBatchId("/batches/"),
    Batch_DELETE_byBatchId("/batches/"),
    Class_POST_CreateNew("/CreateClassSchedule"),
    Class_GET_AllClassList("/allClasses"),
     Class_GET_allClasses_forParticular_Student("/upcomingClasses/"),
    Class_GET_ClassRecordings_byBatchId("/batchRecordings/"),
    Class_GET_ClassDetails_byClassId("/class/"),
    Class_GET_byClassTopic("/classes/"),
    Class_GET_allClasses_byBatchId("/classesbyBatch/"),
    Class_GET_allClasses_byStaffId("/classesByStaff/"),
    Class_GET_allrecordings("/classrecordings"),
    Class_GET_ClassRecordings_byClassId("/classRecordings/"),
    Class_PUT_NewClass("/updateClass/"),
    Class_PUT_Class_Recording_path("/updateClassrecording/"),
    Class_Delete_byClassId("/deleteByClass/"),
    User_POST("/users/roleStatus"),
	User_GET_AllUsers("/users"),
	User_GET_AllActiveUser("/users/activeUsers"),
	User_GET_emailsofalluserswithActivestatus("/fetch-emails"),
	User_GET_AllRoles("/roles"),
	User_GET_Userinformation_byUserId("/users/U340"),
	User_GET_all_UsersWithRoles("/users/roles"),
	User_GET_CountOfActiveandInActiveUsers("/users/byStatus"),
	User_GET_Userby_ProgramBatches("/users/programBatch/11632"),
	User_GET_UsersforProgram("/users/programs/18971"),
	User_GET_UserBy_RoleId("/users/roles/R02"),
	User_GET_UserByRoleId_V2("/v2/users"),
	User_PUT_byUserId("/users/"),
	User_PUT_byRoleId("/users/roleId"),
	User_PUT_byUserRolePgmBatchStatus("/users/roleProgramBatchStatus/"),
	User_PUT_UpdateUserLoginStatus("/users/userLogin/"),
	User_DELETE_ByUserId("/users/");
	
    private final String path;
    Endpoint(String path){
        this.path = path;
    }
    
    public String getPath() {
        return path;
    }
}
