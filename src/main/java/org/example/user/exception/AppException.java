package org.example.user.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AppException extends RuntimeException {
    private ErrorCode errorCode;

    public AppException( ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
