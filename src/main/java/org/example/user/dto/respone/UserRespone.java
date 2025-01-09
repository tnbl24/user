package org.example.user.dto.respone;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRespone {
    private String id;
    private String username;
    private String password;
    private String name;

    private String email;
    private String gender;
    private String birthday;
}
