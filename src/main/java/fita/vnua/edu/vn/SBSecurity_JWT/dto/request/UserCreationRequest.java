package fita.vnua.edu.vn.SBSecurity_JWT.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
