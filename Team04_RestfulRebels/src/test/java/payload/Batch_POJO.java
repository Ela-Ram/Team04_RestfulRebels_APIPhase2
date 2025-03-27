package payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor   // No-argument constructor
@AllArgsConstructor  // All-argument constructor
@Data               // Generates getter, setter, toString, equals, and hashCode

public class Batch_POJO {
	
	private String batchDescription;
	private String batchName;
	private int batchNoOfClasses;
	private String batchStatus;	
	private int programId;
	
	
	 @JsonIgnore
	 private String endpoint;


}