package company.aex.SpringSecurity.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String JwtToken;
}
