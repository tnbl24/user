package org.example.user.dto.respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiRespone<T> {
    private int code = 1000;
    private String message;
    private T result;
}
