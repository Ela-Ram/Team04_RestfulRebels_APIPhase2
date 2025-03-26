package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor   // No-argument constructor
@AllArgsConstructor  // All-argument constructor
@Data    
public class Class_Put_POJO {
	
	private String classRecordingPath;
    private int csId;

}
