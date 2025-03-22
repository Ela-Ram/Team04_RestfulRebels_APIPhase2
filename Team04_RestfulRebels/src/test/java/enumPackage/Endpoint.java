package enumPackage;

public enum Endpoint {
    Login_POST("/login"),
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
    Class_Delete_byClassId("/deleteByClass/");
    
    private final String path;
    Endpoint(String path){
        this.path = path;
    }
    
    public String getPath() {
        return path;
    }
}
