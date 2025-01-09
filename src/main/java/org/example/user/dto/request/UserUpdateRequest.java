package org.example.user.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    @Size(min = 4, message = "PASSWORD_INVALID")
    private String password;
    private String name;

    private String email;
    private String phone;
    private String address;
    private String gender;
    private String birthday;
}
