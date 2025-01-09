package org.example.user.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 4, max = 50,message = "USER_INVALID")
    String username;

    @Size(min = 4, message = "PASSWORD_INVALID")
    String password;
    String name;

    String email;
    String gender;
    String birthday;
}
