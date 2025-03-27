package payload;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor   // No-argument constructor
@AllArgsConstructor  // All-argument constructor
@Data               // Generates getter, setter, toString, equals, and hashCode
@Builder     // Enables the builder pattern

public class Program_POJO {
	
	
	private String programDescription;
	private String programName;
	private String programStatus;
	
	
	 @JsonIgnore
	 private String endpoint;

	
	
	

}