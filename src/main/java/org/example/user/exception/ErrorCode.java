package org.example.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    USER_EXISTED(1001,"User existed"),
    USER_NOT_EXISTED(1005,"User not existed"),
    USER_INVALID(1002,"User must be at least 4 chars"),
    PASSWORD_INVALID(1003,"Password must be at least 4 chars"),
    KEY_INVALID(1004,"Uncategoride error"),
    UNCATEORIZED_EXCEPTION(1000,"Uncategoride error");

    private int code;
    private String message;
}
