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
public class Login_POJO {
    private String userLoginEmailId;
    private String password;
    
    @JsonIgnore
    private String endpoint;
     
}
