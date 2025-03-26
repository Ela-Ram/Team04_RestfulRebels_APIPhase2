package payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor   // No-argument constructor
@AllArgsConstructor  // All-argument constructor
@Data               // Generates getter, setter

public class Class_POJO {
	private int batchId;
    private int classNo;
    private String classDate;
    private String classTopic;
    private String classStatus;
    private String classStaffId;
    private String classDescription;
    private String classComments;
    private String classNotes;
    private String classRecordingPath;
    private List<String> classScheduledDates;
	
    @JsonIgnore
    private String endpoint;

}
